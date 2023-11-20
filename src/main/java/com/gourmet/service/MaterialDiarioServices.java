package com.gourmet.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gourmet.dao.MaterialDiarioRepository;
import com.gourmet.entity.MaterialDiario;

@Service
public class MaterialDiarioServices {

	@Autowired
	private MaterialDiarioRepository repo;
	
	public void registrar(MaterialDiario m) {
		repo.save(m);
	}
	
	/*public void registrar(MaterialDiarioPorFecha m) {
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
		return repo.noExistePorFecha(fecha);*/
	
	public boolean existeRegistro(int codigo, LocalDate fecha) {
		if (repo.existeRegistro(codigo, fecha)) {
			return true;
		} else {
			return false;
		}
	} 
	
	public List<MaterialDiario> listarMaterialesFechaAerolinea(LocalDate fecha, int codigo ){
		return repo.lista(fecha, codigo);
	}
}
