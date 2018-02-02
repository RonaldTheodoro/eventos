package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Usuario;
import repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
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
