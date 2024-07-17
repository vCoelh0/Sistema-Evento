package com.coelhodev.sistemaevento.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String descricao;
	
	//relacionamento da CATEGORIA com ATIVIDADE
	@OneToMany(mappedBy = "categoria")
	private List<Atividade> atividades = new ArrayList<>();
	
	
	
	// ======================== CONSTRUCTORS  ========================
	public Categoria() {
		
	}
	

	public Categoria(Integer id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}
	
	
	//======================== GETTERS AND SETTERS ========================
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public List<Atividade> getAtividades() {
		return atividades;
	}
	
	
	
}
