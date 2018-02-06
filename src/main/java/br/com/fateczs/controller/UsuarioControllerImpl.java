package br.com.fateczs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.fateczs.model.Usuario;
import br.com.fateczs.service.UsuarioService;

@Controller
public class UsuarioControllerImpl implements UsuarioController {

    @Autowired
    private UsuarioService service;

    @Override
    public boolean isValidUser(Usuario usuario) {
        Usuario usuarioAux = service.buscar(usuario);
        if(usuarioAux != null) {
            if(usuario.getEmail().equalsIgnoreCase(usuarioAux.getEmail()) && usuario.getSenha().equals(usuarioAux.getSenha())) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void cadastroUsuario(Usuario usuario) {
        service.inserir(usuario);
    }

    @Override
    public void alterarUsuario(Usuario usuario) {
        service.alterar(usuario);
        
    }

    @Override
    public void excluirUsuario(Usuario usuario) {
        service.excluir(usuario);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return service.listar();
    }

}
