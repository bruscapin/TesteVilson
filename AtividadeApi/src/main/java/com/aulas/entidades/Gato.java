package com.aulas.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Gato {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	@Column (length = 40, nullable = false)
	private String nome;
	@Column (length = 50, nullable = false)
	private String cor;
	@Column (length = 10, nullable = false)
	private String sexo;
	
	
		public Gato(String nome, String cor, String sexo) {		
		this.nome = nome;
		this.cor = cor;
		this.sexo = sexo;
	}
		
		
	public Gato() {
			
		}

	public Long getId() {
	return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	
}
