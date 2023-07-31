package com.gourmet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gourmet.entity.Material;
import com.gourmet.service.AerolineaServices;
import com.gourmet.service.MaterialServices;
import com.gourmet.service.ServicioServices;

@Controller
@RequestMapping("material")
public class MaterialController {

	@Autowired
	private ServicioServices serSer;
	
	@Autowired
	private AerolineaServices aerSer;
	
	@Autowired
	private MaterialServices matSer;
	
	@RequestMapping("")
	public String material(Model model) {
		model.addAttribute("servicios", serSer.listar());
		model.addAttribute("aerolineas", aerSer.listar());
		model.addAttribute("materiales", matSer.listarMateriales());
		return "material";
	}
	
	@RequestMapping("listarPorSelect")
	@ResponseBody
	public List<Material> materialPorSelect(@RequestParam("cboAerolinea") int codAer, @RequestParam("cboServicio") int codSer) {	
		
		if(codAer != 0 && codSer != 0) {
		return matSer.materialPorSelect(codAer, codSer);
		} else if (codAer == 0){
			return matSer.materialPorServicio(codSer);
		} else {
			return matSer.materialPorAerolinea(codAer);
		}
	}
	
	@PostMapping("/registrar")
	public String registrarMaterial(Material material) {
		matSer.registrar(material);
		return "redirect:/material";
	}
	
	
}
