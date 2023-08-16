package com.gourmet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public List<Region> regionesPorPais(@RequestParam("codigoPais") int codi){		
		return regSer.listarRegionesPorPais(codi);
	}
	
	@RequestMapping("/buscarAer")
	@ResponseBody
	public Aeropuerto buscarAeropuerto(@RequestParam("codigoAer") int cod) {
		return aerSer.buscarAeropuerto(cod);
	}
	
	@PostMapping("/guardarPais")
	public String guardarPais(Pais p) {
		paiSer.registrarPais(p);
		return "redirect:/aeropuerto";
	}
	
	@PostMapping("/guardarRegion")
	public String guardarRegion(Region r) {
		regSer.registrar(r);
		return "redirect:/aeropuerto";
	}
	
	@PostMapping("/guardarAeropuerto")
	public String guardarAeropuerto(Aeropuerto a) {
		aerSer.registrarAeropuerto(a);
		return "redirect:/aeropuerto";
	}
	
}
