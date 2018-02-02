package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario_has_evento")
public class UsuarioEvento implements Serializable {

	@Id
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	@Id
    @ManyToOne
    @JoinColumn(name = "evento_id")
	private Evento evento;
	@Column(name = "comparecimento")
	private boolean comparecimento;
	
	
	public UsuarioEvento(Usuario usuario, Evento evento) {
		this.usuario = usuario;
		this.evento = evento;
	}
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	public boolean isComparecimento() {
		return comparecimento;
	}
	public void setComparecimento(boolean comparecimento) {
		this.comparecimento = comparecimento;
	}
	
}
