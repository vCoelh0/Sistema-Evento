package com.coelhodev.sistemaevento.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_participante")
public class Participante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private String email;
	
	
	//relacionamento para atividades
	@ManyToMany
	 @JoinTable(
		        name = "tb_participacao",
		        joinColumns = @JoinColumn(name = "participante_id"),
		        inverseJoinColumns = @JoinColumn(name = "atividade_id")
		    )
	private Set<Atividade> atividades = new HashSet<>();
	
	
	
	
	
	
	
	
	
	// =============== construtores =====================
	public Participante() {
		
	}
	
	// ============ getter and setter =================

	public Participante(Integer id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAtividades(Set<Atividade> atividades) {
		this.atividades = atividades;
	}
	
	
	
	
	
	
	
}
