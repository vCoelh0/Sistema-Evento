package com.coelhodev.sistemaevento.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_atividade")
public class Atividade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private String descricao;
	private Double preco;
	
	//RELACIONAMENTO DA ATIVIDADE COM CATEGORIA
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	
	//RELACIONAMENTO DE Bloco
	@OneToMany(mappedBy = "atividade")
	private List<Bloco> blocos = new ArrayList<>();
	
	// RELACIONAMENTO COM PARTICIPANTE
	@ManyToMany
	 @JoinTable(
		        name = "tb_participacao",
		        joinColumns = @JoinColumn(name = "atividade_id"),
		        inverseJoinColumns = @JoinColumn(name = "participante_id")
		    )
	private Set<Participante> participantes = new HashSet<>();
	
// ================ CONSTRUCTORS ========================
	
	
	public Atividade() {
		
	}


	public Atividade(Integer id, String nome, String descricao, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}

	// ===================== GETTERS AND SETTERS =============================
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


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Double getPreco() {
		return preco;
	}


	public void setPreco(Double preco) {
		this.preco = preco;
	}


	public List<Bloco> getBlocos() {
		return blocos;
	}


	public void setParticipantes(Set<Participante> participantes) {
		this.participantes = participantes;
	}


	

	
	
	
}
