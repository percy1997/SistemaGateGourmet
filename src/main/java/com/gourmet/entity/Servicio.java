package com.gourmet.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "servicio")
public class Servicio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_ser")
	private Integer codigoServicio;
	
	@Column(name="nom_ser")
	private String nombreServicio;
	
	@Column(name="abr_ser")
	private String abreviaturaServicio;
	
	@OneToMany(mappedBy = "tipoServicio")
	@JsonIgnore
	List<Material> listaMaterial;

	public Integer getCodigoServicio() {
		return codigoServicio;
	}

	public void setCodigoServicio(Integer codigoServicio) {
		this.codigoServicio = codigoServicio;
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	public String getAbreviaturaServicio() {
		return abreviaturaServicio;
	}

	public void setAbreviaturaServicio(String abreviaturaServicio) {
		this.abreviaturaServicio = abreviaturaServicio;
	}

	public List<Material> getListaMaterial() {
		return listaMaterial;
	}

	public void setListaMaterial(List<Material> listaMaterial) {
		this.listaMaterial = listaMaterial;
	}
		
	
}
