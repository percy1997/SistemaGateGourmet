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
@Table(name="material_diario")
public class MaterialDiario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_mat_d")
	private Integer codigoMaterialDiario;
	
	@Column(name = "cantidad")
	private int cantidadMaterialDiario;
	
	@ManyToOne
	@JoinColumn(name ="cod_mat_df")
	private MaterialDiarioPorFecha materialDPF;
	
	@ManyToOne
	@JoinColumn(name ="cod_mat")
	private Material material;

	public Integer getCodigoMaterialDiario() {
		return codigoMaterialDiario;
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

	public MaterialDiarioPorFecha getMaterialDPF() {
		return materialDPF;
	}

	public void setMaterialDPF(MaterialDiarioPorFecha materialDPF) {
		this.materialDPF = materialDPF;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}
}
