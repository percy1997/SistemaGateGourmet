package com.gourmet.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gourmet.dao.MaterialDiarioFechaRepository;
import com.gourmet.entity.MaterialDiarioPorFecha;

@Service
public class MaterialDiarioFechaServices {

	@Autowired
	private MaterialDiarioFechaRepository repo;
	
	public void registrar(MaterialDiarioPorFecha m) {
		repo.save(m);
	}
	
	public MaterialDiarioPorFecha obtenerMaterialPorAerFec(LocalDate fecha, int codigo) {
		return repo.existeMaterialCodFec(fecha, codigo);
	}
	
	public boolean buscarFecha(LocalDate fecha) {
		if (repo.existeFecha(fecha)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean existeRegistroPorFecha(LocalDate fecha) {
		return repo.noExistePorFecha(fecha);
	}
}
