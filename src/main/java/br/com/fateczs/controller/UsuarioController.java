package br.com.fateczs.controller;

import java.util.List;

import br.com.fateczs.model.Usuario;

public interface UsuarioController {

    public boolean isValidUser(Usuario usuario);

    public void cadastroUsuario(Usuario usuario);

    public void alterarUsuario(Usuario usuario);

    public void excluirUsuario(Usuario usuario);

    public List<Usuario> listarUsuarios();

}
