package com.gourmet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gourmet.service.AerolineaServices;
import com.gourmet.service.MaterialServices;

@Controller
@RequestMapping("/registroDiario")
public class RegistroDiarioController {
	
	@Autowired
	private AerolineaServices aerSer;
	
	@Autowired
	private MaterialServices matSer;
	
	@RequestMapping("")
	public String listaInicial(Model model) {
		model.addAttribute("aerolineas", aerSer.listar());
		return "registroDiario";
	}
	
	@RequestMapping("formulario")
	public String formulario(Model model) {
		model.addAttribute("aerolineas", aerSer.listar());
		model.addAttribute("material", matSer.materialPorAerolinea(1));
		return "registroDiarioFormulario";
	}
}
