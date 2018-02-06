package br.com.fateczs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fateczs.model.Usuario;
import br.com.fateczs.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements IService<Usuario> {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public Usuario buscar(Usuario usuario) {
        return repository.findOne(usuario.getEmail());
    }

    @Override
    public void inserir(Usuario usuario) {
        repository.save(usuario);
    }

    @Override
    public void alterar(Usuario usuario) {
        repository.save(usuario);
    }

    @Override
    public void excluir(Usuario usuario) {
        repository.delete(usuario);
    }

    @Override
    public List<Usuario> listar() {
        return repository.findAll();
    }

}
