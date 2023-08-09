package com.gourmet.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="aeropuerto")
public class Aeropuerto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_air")
	private Integer codigoAeropuerto;
	
	@Column(name = "nom_air")
	private String nombreAeropuerto;
	
	@Column(name = "cod_iata_air")
	private String codigoIataAeropuerto;
	
	@ManyToOne
	@JoinColumn(name = "cod_reg")
	private Region regiones;
	
	@ManyToOne
	@JoinColumn(name = "cod_pai")
	private Pais paises;

	public Integer getCodigoAeropuerto() {
		return codigoAeropuerto;
	}

	public void setCodigoAeropuerto(Integer codigoAeropuerto) {
		this.codigoAeropuerto = codigoAeropuerto;
	}

	public String getNombreAeropuerto() {
		return nombreAeropuerto;
	}

	public void setNombreAeropuerto(String nombreAeropuerto) {
		this.nombreAeropuerto = nombreAeropuerto;
	}

	public String getCodigoIataAeropuerto() {
		return codigoIataAeropuerto;
	}

	public void setCodigoIataAeropuerto(String codigoIataAeropuerto) {
		this.codigoIataAeropuerto = codigoIataAeropuerto;
	}

	public Region getRegiones() {
		return regiones;
	}

	public void setRegiones(Region regiones) {
		this.regiones = regiones;
	}

	public Pais getPaises() {
		return paises;
	}

	public void setPaises(Pais paises) {
		this.paises = paises;
	}
	
}
