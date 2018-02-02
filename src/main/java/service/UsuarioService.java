package service;

import java.util.List;

import model.Usuario;

public interface UsuarioService {
	
	public Usuario buscar(Usuario usuario);

	public void inserir(Usuario usuario);
	
	public void alterar(Usuario usuario);
	
	public void excluir(Usuario usuario);
	
	public List<Usuario> listar();
	
	
}
