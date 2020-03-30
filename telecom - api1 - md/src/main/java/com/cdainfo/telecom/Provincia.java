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
@Table(name = "PROVINCIA")
@Data
@RestResource(rel="provincia", path="provincia")
public class Provincia implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PROVINCIA")
	private Long id;

	@Column(name = "NOMBRE")
	private String nombreProvincia;

	    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "ID_PAIS", nullable = false)
    @JsonBackReference
    private Pais pais;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,
    		 orphanRemoval = true, mappedBy = "provincia")
    @JsonManagedReference
    private Set<Partido> Partido;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreProvincia() {
		return nombreProvincia;
	}

	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Set<Partido> getPartido() {
		return Partido;
	}

	public void setPartido(Set<Partido> partido) {
		Partido = partido;
	}

	@Override
	public String toString() {
		return "Provincia [id=" + id + ", nombreProvincia=" + nombreProvincia + ", pais=" + pais + ", Partido="
				+ Partido + "]";
	}

}
