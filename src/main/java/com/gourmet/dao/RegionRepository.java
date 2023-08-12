package com.gourmet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gourmet.entity.Region;

public interface RegionRepository extends JpaRepository<Region, Integer>{
	
	@Query("select r from Region r where r.paises.codigoPais = ?1")
	public List<Region> listarRegionesPorPais(int codigoPais);

}
