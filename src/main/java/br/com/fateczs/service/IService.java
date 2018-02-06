package br.com.fateczs.service;

import java.util.List;

public interface IService<T> {

    public T buscar(T instancia);

    public void inserir(T instancia);

    public void alterar(T instancia);

    public void excluir(T instancia);

    public List<T> listar();

}
