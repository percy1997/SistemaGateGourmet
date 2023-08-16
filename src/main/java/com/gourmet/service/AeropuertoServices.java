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
	
	public List<Aeropuerto> listaAeropuertos(){
		return repo.findAll();
	}
	
	public void registrarAeropuerto(Aeropuerto a) {
		repo.save(a);
	}
	
	public void actualizar(Aeropuerto a) {
		repo.save(a);
	}
	
	public Aeropuerto buscarAeropuerto(int cod) {
		return repo.findById(cod).orElse(null);
	}
}
