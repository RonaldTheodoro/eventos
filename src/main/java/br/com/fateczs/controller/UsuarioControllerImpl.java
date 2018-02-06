package br.com.fateczs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.fateczs.model.Usuario;
import br.com.fateczs.service.IService;

@Controller
public class UsuarioControllerImpl implements IController<Usuario> {

    @Autowired
    private IService service;

    @Override
    public boolean isValid(Usuario usuario) {
        Usuario usuarioAux = (Usuario) service.buscar(usuario);
        if(usuarioAux != null) {
            if(usuario.getEmail().equalsIgnoreCase(usuarioAux.getEmail()) 
               && usuario.getSenha().equals(usuarioAux.getSenha())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void cadastro(Usuario usuario) {
        service.inserir(usuario);
    }

    @Override
    public void alterar(Usuario usuario) {
        service.alterar(usuario);
    }

    @Override
    public void excluir(Usuario usuario) {
        service.excluir(usuario);
    }

    @Override
    public List<Usuario> listar() {
        return service.listar();
    }

}
