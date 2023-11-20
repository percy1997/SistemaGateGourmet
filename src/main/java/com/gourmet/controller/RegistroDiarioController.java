package com.gourmet.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gourmet.entity.Aerolinea;
import com.gourmet.entity.Material;
import com.gourmet.entity.MaterialDiario;
import com.gourmet.service.AerolineaServices;
import com.gourmet.service.MaterialDiarioServices;
import com.gourmet.service.MaterialServices;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/registroDiario")
public class RegistroDiarioController {
	
	@Autowired
	private AerolineaServices aerSer;
	
	@Autowired
	private MaterialServices matSer;
	
	@Autowired
	private MaterialDiarioServices matDiaSer;
	
	@RequestMapping("")
	public String listaInicial(Model model) {
		model.addAttribute("aerolineas", aerSer.listar());
		return "registroDiario";
	}
	
	@RequestMapping("formulario")
	public String formulario(Model model,@RequestParam("cod") int codigo) {
		
		LocalDate fechaActual = LocalDate.now();

        // Formatear la fecha en el formato AAAA-MM-DD
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaFormateada = fechaActual.format(formatter);
        
		model.addAttribute("aerolineas", aerSer.listar());
		model.addAttribute("material", matSer.materialPorAerolinea(codigo));
        model.addAttribute("dato", codigo);
        model.addAttribute("fechaActual", fechaFormateada);

        
		return "registroDiarioFormulario";
	}
 	
	@RequestMapping("registrar")
	public ResponseEntity<String> registro(Model model,
			@RequestParam("codigoAerolinea") int codigoAerolinea,
			@RequestParam("fecha") String fecha,
			@RequestParam("cantidadDiaria") int cantidad,
			@RequestParam("codigoMaterial") int codigoMaterial,
			RedirectAttributes redirect) {
		model.addAttribute("aerolineas", aerSer.listar());
		
		boolean registroEncontrado = matDiaSer.existeRegistro(codigoMaterial, LocalDate.parse(fecha));
		
		if(registroEncontrado == true) {
			MaterialDiario md = new MaterialDiario();
			
			md.setCantidadMaterialDiario(cantidad);
						
			Material m = new Material();
			m.setCodigoMaterial(codigoMaterial);
			md.setMaterial(m);
			
			md.setFechaMDPF(LocalDate.parse(fecha));
			
			Aerolinea aer = new Aerolinea();
			aer.setCodigoAerolinea(codigoAerolinea);
			md.setAerolinea(aer);	
			
			matDiaSer.registrar(md);
			redirect.addFlashAttribute("MENSAJE", "Registro exitoso");
	        return ResponseEntity.ok("Registro exitoso");
					
		} else{
			
			redirect.addFlashAttribute("MENSAJE", "Registro ya existe");
	        return ResponseEntity.ok("Registro existe");
		}
		
	}
	
	@RequestMapping("listar")
	public String listaBuscar(Model model) {
		model.addAttribute("aerolineas", aerSer.listar());
		return "registroDiarioListaBuscar";
	}
	
	@RequestMapping("listado")
	public String listado(Model model,
			@RequestParam("fechaFormulario") String fecha,
			@RequestParam("codigoAerolinea") int cboAerolinea) {
		model.addAttribute("aerolineas", aerSer.listar());
		model.addAttribute("items", matDiaSer.listarMaterialesFechaAerolinea(LocalDate.parse(fecha), cboAerolinea));		
        model.addAttribute("dato1", fecha);
        model.addAttribute("dato2", cboAerolinea);
		
		return "registroDiarioListado";
	}	
	
	@RequestMapping("/generar-excel")
    public void generarExcel(@RequestParam("fechaExcel") String fecha,
                             @RequestParam("codigoAerolineaExcel") int cboAerolinea,
                             HttpServletResponse response) {

        // Obtén la lista de datos desde el servicio
        List<MaterialDiario> listaExcel = matDiaSer.listarMaterialesFechaAerolinea(LocalDate.parse(fecha), cboAerolinea);

        // Crear un libro de trabajo de Excel
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Materiales");

            // Crear la fila de encabezados
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Codigo");
            headerRow.createCell(1).setCellValue("Material");
            headerRow.createCell(2).setCellValue("Cantidad");
            headerRow.createCell(3).setCellValue("Fecha");
            headerRow.createCell(4).setCellValue("Aerolinea");

            // Establecer el estilo de celda para los encabezados
            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            Font headerFont = workbook.createFont();
            headerFont.setColor(IndexedColors.SKY_BLUE.getIndex());
            headerStyle.setFont(headerFont);

            for (int i = 0; i < headerRow.getPhysicalNumberOfCells(); i++) {
                Cell cell = headerRow.getCell(i);
                cell.setCellStyle(headerStyle);
            }

            CellStyle dateCellStyle = workbook.createCellStyle();
            CreationHelper creationHelper = workbook.getCreationHelper();
            dateCellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("dd-MM-yyyy"));

            int rowNum = 1;
            for (MaterialDiario material : listaExcel) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(material.getCodigoMaterialDiario());
                row.createCell(1).setCellValue(material.getMaterial().getDescripcionMaterial());
                row.createCell(2).setCellValue(material.getCantidadMaterialDiario());

                Cell dateCell = row.createCell(3);
                dateCell.setCellValue(material.getFechaMDPF());
                dateCell.setCellStyle(dateCellStyle);

                row.createCell(4).setCellValue(material.getAerolinea().getNombreAerolinea());
            }

            // Establecer el ancho de las columnas
            sheet.setColumnWidth(1, 50 * 256); // Columna 2
            sheet.setColumnWidth(3, 20 * 256); // Columna 3

            // Configurar el tipo de contenido y encabezado para la respuesta
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment; filename=datos.xlsx");

            // Escribir el libro de trabajo en la respuesta
            workbook.write(response.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}