package com.gourmet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gourmet.service.AeropuertoServices;

@Controller
@RequestMapping("/aeropuerto")
public class AeropuertoController {

	@Autowired
	private AeropuertoServices aerSer;
	
	@RequestMapping("")
	public String aeropuerto(Model model) {
		model.addAttribute("aeropuertos", aerSer.listaAeropuertos());
		return "aeropuerto";
	}
}
