package com.gourmet.service;

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
}
