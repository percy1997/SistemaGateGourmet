package com.gourmet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gourmet.entity.Material;

public interface MaterialRepository extends JpaRepository<Material, Integer> {

	@Query("select m from Material m where m.aerolinea.codigoAerolinea = ?1 and m.tipoServicio.codigoServicio = ?2")
	public List<Material> listarMaterialPorSelect(int codigoAer, int codigoSer);
	
	@Query("select m from Material m where m.aerolinea.codigoAerolinea = ?1")
	public List<Material> listarMaterialPorAerolinea(int codigoAer);
	
	@Query("select m from Material m where m.tipoServicio.codigoServicio = ?1")
	public List<Material> listarMaterialPorServicio(int codigoSer);
	
}
