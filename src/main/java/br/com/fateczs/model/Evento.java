package br.com.fateczs.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "nome_Palestrante")
    private String nomePalestrante;

    @Column(name = "carga_Horaria")
    private Double cargaHoraria;

    @Column(name = "data_Evento")
    private String dataEvento;

    @Column(name = "local")
    private String local;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
    private Set<UsuarioEvento> usuarioEventos;

    public Evento () { }

    public Evento (Integer id,
                   String categoria,
                   String nome,
                   String descricao,
                   String nomePalestrante,
                   Double cargaHoraria) {
        this.id = id;
        this.categoria = categoria;
        this.nome = nome;
        this.descricao = descricao;
        this.nomePalestrante = nomePalestrante;
        this.cargaHoraria = cargaHoraria;
        this.usuarioEventos = new HashSet<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNomePalestrante() {
        return nomePalestrante;
    }

    public void setNomePalestrante(String nomePalestrante) {
        this.nomePalestrante = nomePalestrante;
    }

    public Double getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(String dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Override
    public String toString() {
        return this.id + " - " + this.nome;
    }

    public Set<UsuarioEvento> getUsuarioEventos() {
        return usuarioEventos;
    }

    public void setUsuarioEventos(Set<UsuarioEvento> usuarioEventos) {
        this.usuarioEventos = usuarioEventos;
    }

}
