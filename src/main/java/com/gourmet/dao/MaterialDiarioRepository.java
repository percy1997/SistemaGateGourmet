package com.gourmet.dao;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gourmet.entity.MaterialDiario;

public interface MaterialDiarioRepository extends JpaRepository<MaterialDiario, Integer>{

	/*@Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM MaterialDiarioPorFecha u WHERE u.fechaMDPF = ?1")
	    boolean existeFecha(LocalDate fecha);
	 
	 
	 @Query("select m from MaterialDiarioPorFecha m where m.fechaMDPF = ?1 and m.aerolinea.codigoAerolinea = ?2" )
	 	public MaterialDiarioPorFecha existeMaterialCodFec(LocalDate fecha, int codigo);
	 
	 @Query("SELECT CASE WHEN COUNT(u) > 0 THEN false ELSE true END FROM MaterialDiarioPorFecha u WHERE u.fechaMDPF = :fechaMDPF")
	    boolean noExistePorFecha(LocalDate fecha);*/
	
	 @Query("SELECT CASE WHEN COUNT(u) > 0 THEN false ELSE true END FROM MaterialDiario u WHERE u.material.codigoMaterial = ?1 and u.fechaMDPF = ?2")
	    boolean existeRegistro(int codigo, LocalDate fecha);
}
