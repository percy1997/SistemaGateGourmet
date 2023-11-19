package com.gourmet.entity;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="material_diario")
public class MaterialDiario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_mat_d")
	private Integer codigoMaterialDiario;
	
	@Column(name = "cantidad")
	private int cantidadMaterialDiario;
	
	@Column(name="fecha_mat_d")
	private LocalDate fechaMDPF;
	
	@ManyToOne
	@JoinColumn(name ="cod_mat")
	private Material material;

	@ManyToOne
	@JoinColumn(name ="cod_aer")
	private Aerolinea aerolinea;
	
	public Integer getCodigoMaterialDiario() {
		return codigoMaterialDiario;
	}

	public LocalDate getFechaMDPF() {
		return fechaMDPF;
	}

	public void setFechaMDPF(LocalDate fechaMDPF) {
		this.fechaMDPF = fechaMDPF;
	}

	public Aerolinea getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(Aerolinea aerolinea) {
		this.aerolinea = aerolinea;
	}

	public void setCodigoMaterialDiario(Integer codigoMaterialDiario) {
		this.codigoMaterialDiario = codigoMaterialDiario;
	}

	public int getCantidadMaterialDiario() {
		return cantidadMaterialDiario;
	}

	public void setCantidadMaterialDiario(int cantidadMaterialDiario) {
		this.cantidadMaterialDiario = cantidadMaterialDiario;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}
}
