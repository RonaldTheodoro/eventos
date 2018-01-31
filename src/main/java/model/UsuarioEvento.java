package model;

public class UsuarioEvento {
	
	private Usuario usuario;
	private Evento evento;
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
