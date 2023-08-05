package com.gourmet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gourmet.entity.Aerolinea;
import com.gourmet.service.AerolineaServices;

@Controller
@RequestMapping("/aerolinea")
public class AerolineaController {

	@Autowired
	private AerolineaServices aerSer;

	// listar aerolineas
	@RequestMapping("")
	public String lista(Model model) {
		model.addAttribute("aerolineas", aerSer.listar());
		return "aerolinea";
	}

	// registrar una aerolinea
	@PostMapping("/registrar")
	public String registrarAerolinea(Aerolinea aerolinea, @RequestParam("codigoAerolinea") int cod,
			RedirectAttributes redirect) {
		if (cod == 0) {
			aerSer.registrar(aerolinea);
			redirect.addFlashAttribute("MENSAJE","Aerolínea registrada con exito");
			return "redirect:/aerolinea";
		} else
			aerSer.actualizar(aerolinea);
			redirect.addFlashAttribute("MENSAJE","Aerolínea actualizada con exito");
			return "redirect:/aerolinea";

	}

	// obtener JSON de aerolinea
	@RequestMapping("/obtenerJSONAer")
	@ResponseBody
	public Aerolinea obtenerJSONAerolinea(@RequestParam("cod") int codigoAer) {
		return aerSer.obtenerAerolineaPorCodigo(codigoAer);
	}

}
