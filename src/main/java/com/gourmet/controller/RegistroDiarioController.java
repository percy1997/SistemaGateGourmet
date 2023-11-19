package com.gourmet.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
import com.gourmet.entity.MaterialDiarioPorFecha;
import com.gourmet.service.AerolineaServices;
import com.gourmet.service.MaterialDiarioFechaServices;
import com.gourmet.service.MaterialDiarioServices;
import com.gourmet.service.MaterialServices;

@Controller
@RequestMapping("/registroDiario")
public class RegistroDiarioController {
	
	@Autowired
	private AerolineaServices aerSer;
	
	@Autowired
	private MaterialServices matSer;
	
	@Autowired
	private MaterialDiarioServices matDiaSer;
	
	@Autowired
	private MaterialDiarioFechaServices matDiaFecSer;
	
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
			@RequestParam("codigoMaterial") int codigoMaterial) {
		model.addAttribute("aerolineas", aerSer.listar());
		
		boolean fechaEncontrada = matDiaFecSer.buscarFecha(LocalDate.parse(fecha));
		
		if(fechaEncontrada == false) {	
			
			MaterialDiarioPorFecha mdpf = new MaterialDiarioPorFecha();
			Aerolinea aer = new Aerolinea();
			aer.setCodigoAerolinea(codigoAerolinea);
			mdpf.setAerolinea(aer);		
			mdpf.setFechaMDPF(LocalDate.parse(fecha));
			matDiaFecSer.registrar(mdpf);
			
			
			MaterialDiario md = new MaterialDiario();
			md.setCantidadMaterialDiario(cantidad);
			
			md.setMaterialDPF(mdpf);
			
			Material m = new Material();
			m.setCodigoMaterial(codigoMaterial);
			md.setMaterial(m);
			
			matDiaSer.registrar(md);
					
		} else{
			
			MaterialDiarioPorFecha mdpf1 = matDiaFecSer.obtenerMaterialPorAerFec(LocalDate.parse(fecha), codigoAerolinea);
			MaterialDiario md = new MaterialDiario();
			md.setCantidadMaterialDiario(cantidad);
			
			md.setMaterialDPF(mdpf1);
			
			Material m = new Material();
			m.setCodigoMaterial(codigoMaterial);
			md.setMaterial(m);		
			matDiaSer.registrar(md);
		}
		
	/*	MaterialDiario md = new MaterialDiario();
		md.setCantidadMaterialDiario(cantidad);
		
		MaterialDiarioPorFecha mdpf = new MaterialDiarioPorFecha(1);
		md.setMaterialDPF(mdpf);
		
		Material m = new Material();
		m.setCodigoMaterial(codigoMaterial);
		md.setMaterial(m);
		
		matDiaSer.registrar(md);*/
		
		//return "redirect:/registroDiario/formulario?cod=" + codigo;
        return ResponseEntity.ok("Registro exitoso");
	}
	
	@RequestMapping("registrarmpf")
	public String registrarmpf(@RequestParam("codigoAerolinea") int codigoAerolinea,
			@RequestParam("fecha") String fecha,
			RedirectAttributes redirect) {
		
		
		
		MaterialDiarioPorFecha mdpf = new MaterialDiarioPorFecha();
		Aerolinea aer = new Aerolinea();
		aer.setCodigoAerolinea(codigoAerolinea);
		mdpf.setAerolinea(aer);		
		mdpf.setFechaMDPF(LocalDate.parse(fecha));

		boolean fechaEncontrada = matDiaFecSer.buscarFecha(LocalDate.parse(fecha));
		
		if (fechaEncontrada) {
			redirect.addFlashAttribute("MENSAJE", "Fecha existe");			
		}
		else {
			redirect.addFlashAttribute("MENSAJE", "Registro exitoso");
			matDiaFecSer.registrar(mdpf);
		}
			
		//return "redirect:/registroDiario/formulario?cod=" + codigo;
        return "redirect:/registroDiario/formulario?cod=" + codigoAerolinea;
		
	/*	int validar = matDiaFecSer.existe(LocalDate.parse(fecha));
		
		if (validar == 1) {
			redirect.addFlashAttribute("MENSAJE", "Fecha existe");			
	        return "redirect:/registroDiario/formulario?cod=" + codigoAerolinea;
		} else {
			redirect.addFlashAttribute("MENSAJE", "Registro exitoso");
			matDiaFecSer.registrar(mdpf);
		}
        return "redirect:/registroDiario/formulario?cod=" + codigoAerolinea;
*/
	}
}