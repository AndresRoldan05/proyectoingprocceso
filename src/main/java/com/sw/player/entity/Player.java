package com.sw.player.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="players")
public class Player {
	
	@Id
	@GeneratedValue(generator="system-uuid")//esto es necesario ya que es tipo String
	@GenericGenerator(name="system-uuid", strategy = "uuid") //Por ser un autogenerado de string
	@Column(name="id")
	private String id;
	
	@Column(name="nombre", unique=true)
	private String nombre;
	
	@Column(name="curso")
	private String curso;
	
	@Column(name="estudiante")
	private boolean estudiante;
	
	public Player(String id, String nombre, String curso, boolean estudiante) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.curso = curso;
		this.estudiante = estudiante;
	} 
		
	public Player() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
	public boolean isEstudiante() {
		return estudiante;
	}

	public void setEstudiante(boolean estudiante) {
		this.estudiante = estudiante;
	}

}