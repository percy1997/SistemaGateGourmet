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
@Table(name = "aerolinea")
public class Aerolinea {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_aer")
	private Integer codigoAerolinea;
	
	@Column(name = "nom_aer")
	private String nombreAerolinea;
	
	@Column(name="abr_aer")
	private String abreviaturaAerolinea;
	
	@Column(name = "indicativo_aer")
	private String indicativoAerolinea;
	
	@OneToMany(mappedBy = "aerolinea")
	@JsonIgnore
	List<Material> listaMaterial;

	public List<MaterialDiarioPorFecha> getListaMaterialDPF() {
		return listaMaterialDPF;
	}

	public void setListaMaterialDPF(List<MaterialDiarioPorFecha> listaMaterialDPF) {
		this.listaMaterialDPF = listaMaterialDPF;
	}

	@OneToMany(mappedBy = "aerolinea")
	@JsonIgnore
	List<MaterialDiarioPorFecha> listaMaterialDPF;
	
	public Integer getCodigoAerolinea() {
		return codigoAerolinea;
	}

	public void setCodigoAerolinea(Integer codigoAerolinea) {
		this.codigoAerolinea = codigoAerolinea;
	}

	public String getNombreAerolinea() {
		return nombreAerolinea;
	}

	public void setNombreAerolinea(String nombreAerolinea) {
		this.nombreAerolinea = nombreAerolinea;
	}

	public String getAbreviaturaAerolinea() {
		return abreviaturaAerolinea;
	}

	public void setAbreviaturaAerolinea(String abreviaturaAerolinea) {
		this.abreviaturaAerolinea = abreviaturaAerolinea;
	}

	public String getIndicativoAerolinea() {
		return indicativoAerolinea;
	}

	public void setIndicativoAerolinea(String indicativoAerolinea) {
		this.indicativoAerolinea = indicativoAerolinea;
	}

	public List<Material> getListaMaterial() {
		return listaMaterial;
	}

	public void setListaMaterial(List<Material> listaMaterial) {
		this.listaMaterial = listaMaterial;
	}

}
