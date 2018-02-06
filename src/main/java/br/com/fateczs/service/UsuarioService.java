package br.com.fateczs.service;

import java.util.List;

import br.com.fateczs.model.Usuario;

public interface UsuarioService {

    public Usuario buscar(Usuario usuario);

    public void inserir(Usuario usuario);

    public void alterar(Usuario usuario);

    public void excluir(Usuario usuario);

    public List<Usuario> listar();

}