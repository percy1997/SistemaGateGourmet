package com.gourmet.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="region")
public class Region {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_reg")
	private Integer codigoRegion;
	
	@Column(name = "nom_reg")
	private String nombreRegion;
	
	@ManyToOne
	@JoinColumn(name = "cod_pai")
	private Pais paises;

	@OneToMany(mappedBy = "regiones")
	@JsonIgnore
	List<Aeropuerto> listaAeropuertos;
	
	public Integer getCodigoRegion() {
		return codigoRegion;
	}

	public void setCodigoRegion(Integer codigoRegion) {
		this.codigoRegion = codigoRegion;
	}

	public String getNombreRegion() {
		return nombreRegion;
	}

	public void setNombreRegion(String nombreRegion) {
		this.nombreRegion = nombreRegion;
	}

	public Pais getPaises() {
		return paises;
	}

	public void setPaises(Pais paises) {
		this.paises = paises;
	}

	public List<Aeropuerto> getListaAeropuertos() {
		return listaAeropuertos;
	}

	public void setListaAeropuertos(List<Aeropuerto> listaAeropuertos) {
		this.listaAeropuertos = listaAeropuertos;
	}
	
}
