package com.gourmet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gourmet.dao.AerolineaRepository;
import com.gourmet.entity.Aerolinea;

@Service
public class AerolineaServices {
	
	@Autowired
	private AerolineaRepository repo;
	
	//registrar aerolinea
	public void registrar(Aerolinea a) {
		repo.save(a);
	}
	
	//actualizar aerolinea
	public void actualizar(Aerolinea a) {
		repo.save(a);
	}
		
	//listar aerolineas
	public List<Aerolinea> listar(){
		return repo.findAll();
	}
	

}
