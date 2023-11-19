package com.gourmet.entity;

import java.time.LocalDate;
import java.util.Date;
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
@Table(name="material_diario_por_fecha")
public class MaterialDiarioPorFecha {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_mat_df")
	private Integer codigoMDPF;	
	
	@Column(name="fecha_mat_df")
	private LocalDate fechaMDPF;
	
	@ManyToOne
	@JoinColumn(name ="cod_aer")
	private Aerolinea aerolinea;
	
	@OneToMany(mappedBy = "materialDPF")
	@JsonIgnore
	List<MaterialDiario> listaMaterialDiario;


	public MaterialDiarioPorFecha() {
		super();
	}

	public MaterialDiarioPorFecha(Integer codigoMDPF) {
		super();
		this.codigoMDPF = codigoMDPF;
	}

	public List<MaterialDiario> getListaMaterialDiario() {
		return listaMaterialDiario;
	}

	public void setListaMaterialDiario(List<MaterialDiario> listaMaterialDiario) {
		this.listaMaterialDiario = listaMaterialDiario;
	}

	public Integer getCodigoMDPF() {
		return codigoMDPF;
	}

	public void setCodigoMDPF(Integer codigoMDPF) {
		this.codigoMDPF = codigoMDPF;
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
}
