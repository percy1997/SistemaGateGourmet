package com.gourmet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gourmet.dao.RegionRepository;
import com.gourmet.entity.Region;

@Service
public class RegionServices {
	
	@Autowired
	private RegionRepository repo;
	
	public void registrar(Region r) {
		repo.save(r);
	}
	
	public void actualizar(Region r) {
		repo.save(r);
	}
	
	public List<Region> listaRegiones(){
		return repo.findAll();
	}

}
