package com.gourmet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gourmet.dao.AeropuertoRepository;
import com.gourmet.entity.Aeropuerto;

@Service
public class AeropuertoServices {
	
	@Autowired
	private AeropuertoRepository repo;
	
	//listar aeropuertos
	public List<Aeropuerto> listaAeropuertos(){
		return repo.findAll();
	}
	
	//registrar
	public void registrarAeropuerto(Aeropuerto a) {
		repo.save(a);
	}
	
	//actualizar
	public void actualizar(Aeropuerto a) {
		repo.save(a);
	}
	
	//buscar aeropuerto por codigo
	public Aeropuerto buscarAeropuerto(int cod) {
		return repo.findById(cod).orElse(null);
	}
	
	//eliminar aeropuerto por codigo
	public void eliminar(Integer cod) {
		repo.deleteById(cod);
	}
}
