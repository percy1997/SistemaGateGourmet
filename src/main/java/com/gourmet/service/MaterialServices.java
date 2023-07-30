package com.gourmet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gourmet.dao.MaterialRepository;
import com.gourmet.entity.Material;

@Service
public class MaterialServices {

	@Autowired
	private MaterialRepository repo;

	// registrar
	public void registrar(Material m) {
		repo.save(m);
	}

	// actualizar
	public void actualizar(Material m) {
		repo.save(m);
	}

	// listado
	public List<Material> listarMateriales() {
		return repo.findAll();
	}

	// buscar por codigo
	public Material buscarPorCodigo(Integer cod) {
		return repo.findById(cod).orElse(null);
	}

	// eliminar por codigo
	public void eliminar(Integer cod) {
		repo.deleteById(cod);
	}

	// listar material por select
	public List<Material> materialPorSelect(int codA, int codS) {
		return repo.listarMaterialPorSelect(codA, codS);
	}

	// listar material por aerolinea
	public List<Material> materialPorAerolinea(int codA) {
		return repo.listarMaterialPorAerolinea(codA);
	}

	// listar material por servicio
	public List<Material> materialPorServicio( int codS) {
		return repo.listarMaterialPorServicio(codS);
	}

}
