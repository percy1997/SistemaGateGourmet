package com.gourmet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gourmet.entity.Aeropuerto;
import com.gourmet.entity.Pais;
import com.gourmet.entity.Region;
import com.gourmet.service.AeropuertoServices;
import com.gourmet.service.PaisServices;
import com.gourmet.service.RegionServices;

@Controller
@RequestMapping("/aeropuerto")
public class AeropuertoController {

	@Autowired
	private AeropuertoServices aerSer;
	
	@Autowired
	private RegionServices regSer;
	
	@Autowired
	private PaisServices paiSer;
	
	@RequestMapping("")
	public String aeropuerto(Model model) {
		model.addAttribute("aeropuertos", aerSer.listaAeropuertos());
		model.addAttribute("paises", paiSer.listaPaises());
		return "aeropuerto";
	}
	
	@RequestMapping("listarRegionPorCodigoPais")
	@ResponseBody
	public List<Region> regionesPorPais(@RequestParam("codigoPais") Integer codi){
		return regSer.listarRegionesPorPais(codi);			
	}
	
	@RequestMapping("/buscarAer")
	@ResponseBody
	public Aeropuerto buscarAeropuerto(@RequestParam("codigoAer") int cod) {
		return aerSer.buscarAeropuerto(cod);
	}
	
	@PostMapping("/guardarPais")
	public String guardarPais(Pais p, RedirectAttributes redirect) {
		paiSer.registrarPais(p);
		redirect.addFlashAttribute("MENSAJE","País Registrado");
		return "redirect:/aeropuerto";
	}
	
	@PostMapping("/guardarRegion")
	public String guardarRegion(Region r, RedirectAttributes redirect) {
		regSer.registrar(r);
		redirect.addFlashAttribute("MENSAJE","Región Registrada");
		return "redirect:/aeropuerto";
	}
	
	@PostMapping("/guardarAeropuerto")
	public String guardarAeropuerto(RedirectAttributes redirect, Aeropuerto a, @RequestParam("codigoAeropuerto") int codigo) {
		if(codigo == 0) {
		aerSer.registrarAeropuerto(a);
		redirect.addFlashAttribute("MENSAJE","Aeropuerto Registrado");
		} 
		else {
		aerSer.actualizar(a);
		redirect.addFlashAttribute("MENSAJE","Aeropuerto Actualizado");
		}
		return "redirect:/aeropuerto";
	}
	
	@RequestMapping("/eliminarAeropuerto")
	public String eliminarAeropuerto(@RequestParam("codigoEliminar")int cod) {
		aerSer.eliminar(cod);
		return "redirect:/aeropuerto";
	}
	
}
