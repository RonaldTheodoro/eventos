package controller;

import java.util.List;

import model.Usuario;

public interface UsuarioController {

    public boolean isValidUser(Usuario usuario);

    public void cadastroUsuario(Usuario usuario);

    public void alterarUsuario(Usuario usuario);

    public void excluirUsuario(Usuario usuario);

    public List<Usuario> listarUsuarios();

}
