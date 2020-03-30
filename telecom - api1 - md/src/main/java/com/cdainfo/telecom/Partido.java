package com.cdainfo.telecom;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.rest.core.annotation.RestResource;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Table(name = "PARTIDO")
@Data
@RestResource(rel="partido", path="partido")
public class Partido implements Serializable{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PARTIDO")
	private Long id;

	@Column(name = "NOMBRE")
	private String nombrePartido;

  	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "ID_PROVINCIA", nullable = false)
    @JsonBackReference
    private Provincia provincia;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,
    		 orphanRemoval = true, mappedBy = "partido")
    @JsonManagedReference
    private Set<Localidad> localidad;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombrePartido() {
		return nombrePartido;
	}

	public void setNombrePartido(String nombrePartido) {
		this.nombrePartido = nombrePartido;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public Set<Localidad> getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Set<Localidad> localidad) {
		this.localidad = localidad;
	}

	@Override
	public String toString() {
		return "Partido [id=" + id + ", nombrePartido=" + nombrePartido + ", provincia=" + provincia + ", localidad="
				+ localidad + "]";
	}

	
}