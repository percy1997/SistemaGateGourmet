package com.gourmet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gourmet.entity.MaterialDiario;
import com.gourmet.entity.MaterialDiarioPorFecha;

public interface MaterialDiarioRepository extends JpaRepository<MaterialDiario, Integer>{

}
