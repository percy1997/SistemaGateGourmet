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
}
