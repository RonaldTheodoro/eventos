package model;

import java.util.List;

public class Evento {
	
	private Integer id;
	private String categoria;
	private String nome;
	private String descricao;
	private String nomePalestrante;
	private Double cargaHoraria;
	private String dataEvento;
	private String local;
	private List<Usuario> participantes;
	
	public Evento () {}
	
	public Evento (Integer id, String categoria, String nome, String descricao, String nomePalestrante, Double cargaHoraria) {
		this.id = id;
		this.categoria = categoria;
		this.nome = nome;
		this.descricao = descricao;
		this.nomePalestrante = nomePalestrante;
		this.cargaHoraria = cargaHoraria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
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

	public String getNomePalestrante() {
		return nomePalestrante;
	}

	public void setNomePalestrante(String nomePalestrante) {
		this.nomePalestrante = nomePalestrante;
	}

	public Double getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Double cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public List<Usuario> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Usuario> participantes) {
		this.participantes = participantes;
	}

	public String getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(String dataEvento) {
		this.dataEvento = dataEvento;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}
	
	@Override
	public String toString() {
		return this.id + " - " + this.nome;
	}
}
