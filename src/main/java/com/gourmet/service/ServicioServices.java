package com.gourmet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gourmet.dao.ServicioRepository;
import com.gourmet.entity.Servicio;

@Service
public class ServicioServices {

	@Autowired
	private ServicioRepository repo;
	
	public List<Servicio> listar(){
		return repo.findAll();
	}
}
