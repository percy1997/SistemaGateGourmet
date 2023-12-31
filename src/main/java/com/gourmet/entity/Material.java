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
@Table(name="material")
public class Material {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_mat")
	private Integer codigoMaterial;
	
	@Column(name="des_mat")
	private String descripcionMaterial;
	
	@ManyToOne
	@JoinColumn(name ="cod_aer")
	private Aerolinea aerolinea;
	
	@ManyToOne
	@JoinColumn(name="cod_ser")
	private Servicio tipoServicio;
	
	@OneToMany(mappedBy = "material")
	@JsonIgnore
	List<MaterialDiario> listaMaterialDiario;

	public List<MaterialDiario> getListaMaterialDiario() {
		return listaMaterialDiario;
	}

	public void setListaMaterialDiario(List<MaterialDiario> listaMaterialDiario) {
		this.listaMaterialDiario = listaMaterialDiario;
	}

	public Integer getCodigoMaterial() {
		return codigoMaterial;
	}

	public void setCodigoMaterial(Integer codigoMaterial) {
		this.codigoMaterial = codigoMaterial;
	}

	public String getDescripcionMaterial() {
		return descripcionMaterial;
	}

	public void setDescripcionMaterial(String descripcionMaterial) {
		this.descripcionMaterial = descripcionMaterial;
	}

	public Aerolinea getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(Aerolinea aerolinea) {
		this.aerolinea = aerolinea;
	}

	public Servicio getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(Servicio tipoServicio) {
		this.tipoServicio = tipoServicio;
	}
	
	
}
