package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "endereco")
	private String endereco;
	@Column(name = "email")
	private String email;
	@Column(name = "senha")
	private String senha;
	@Column(name = "adm")
	private boolean adm;
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private Set<UsuarioEvento> usuarioEventos;
	
	public Usuario () {}
	
	public Usuario(Integer id, String nome, String endereco, String email, String senha, boolean adm) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
		this.senha = senha;
		this.adm = adm;
		this.usuarioEventos = new HashSet<>();
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAdm() {
		return adm;
	}

	public void setAdm(boolean adm) {
		this.adm = adm;
	}

	public Set<UsuarioEvento> getUsuarioEventos() {
		return usuarioEventos;
	}

	public void setUsuarioEventos(Set<UsuarioEvento> usuarioEventos) {
		this.usuarioEventos = usuarioEventos;
	}

}
