package com.gourmet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gourmet.entity.Aerolinea;
import com.gourmet.service.AerolineaServices;

@Controller
@RequestMapping("/aerolinea")
public class AerolineaController {

	@Autowired
	private AerolineaServices aerSer;
	
	//listar aerolineas
	@RequestMapping("")
	public String lista(Model model) {
		model.addAttribute("aerolineas",aerSer.listar());
		return "aerolinea";
	}
	
	//registrar una aerolinea
	@PostMapping("/registrar")
	public String registrarAerolinea(Aerolinea aerolinea) {
		aerSer.registrar(aerolinea);
		return "redirect:/aerolinea";
	}
}
