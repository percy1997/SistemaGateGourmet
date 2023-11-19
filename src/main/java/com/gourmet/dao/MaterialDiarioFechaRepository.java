package com.gourmet.dao;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gourmet.entity.MaterialDiarioPorFecha;

public interface MaterialDiarioFechaRepository extends JpaRepository<MaterialDiarioPorFecha, Integer>{

	 @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM MaterialDiarioPorFecha u WHERE u.fechaMDPF = ?1")
	    boolean existeFecha(LocalDate fecha);
	 
	// @Query("")
	 //	public MaterialDiarioPorFecha existeMaterialCodFec(LocalDate fecha, int codigo);
	 
	 @Query("select m from MaterialDiarioPorFecha m where m.fechaMDPF = ?1 and m.aerolinea.codigoAerolinea = ?2" )
	 	public MaterialDiarioPorFecha existeMaterialCodFec(LocalDate fecha, int codigo);
	 
	 @Query("SELECT CASE WHEN COUNT(u) > 0 THEN false ELSE true END FROM MaterialDiarioPorFecha u WHERE u.fechaMDPF = :fechaMDPF")
	    boolean noExistePorFecha(LocalDate fecha);
	 
	 
}
