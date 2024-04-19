package com.jciterceros.domainModelORM.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;

    @OneToMany(mappedBy = "categoria") //Uma Categoria pode ter varias Atividades
    private Set<Atividade> atividades = new HashSet<>();

    public Categoria() {
    }

    public Categoria(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<Atividade> getAtividades() {
        return atividades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(id, categoria.id) && Objects.equals(descricao, categoria.descricao) && Objects.equals(atividades, categoria.atividades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, atividades);
    }

    @Override
    public String toString() {
        return "Categoria {" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", atividades=" + atividades +
                '}';
    }
}