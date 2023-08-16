package com.gourmet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gourmet.dao.PaisRepository;
import com.gourmet.entity.Pais;

@Service
public class PaisServices {
	
	@Autowired
	private PaisRepository repo;
	
	public List<Pais> listaPaises(){
		return repo.findAll();	
	}
	
	public void registrarPais(Pais p) {
		repo.save(p);
	}
}
