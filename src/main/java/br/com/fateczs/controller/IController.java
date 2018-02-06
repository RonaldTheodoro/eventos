package br.com.fateczs.controller;

import java.util.List;

public interface IController<T> {

    public boolean isValid(T instancia);

    public void cadastro(T instancia);

    public void alterar(T instancia);

    public void excluir(T instancia);

    public List<T> listar();

}
