package com.jciterceros.domainModelORM.entities;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "tb_atividade")
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @Column(columnDefinition = "TEXT")
    private String descricao;
    private Double preco;

    @OneToMany(mappedBy = "atividades") //Uma Atividade pode ter varios Blocos
    private List<Bloco> blocos = new ArrayList<>();

    @ManyToOne //Uma Atividade pertence a uma Categoria
    private Categoria categoria;

    @ManyToMany(mappedBy = "atividades")
    //Um Participante pode ter varias Atividades e uma Atividade pode ter varios Participantes
    private Set<Participante> participantes = new HashSet<>();

    public Atividade() {
    }

    public Atividade(Integer id, String nome, String descricao, Double preco, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Set<Participante> getParticipantes() {
        return participantes;
    }

    public List<Bloco> getBlocos() {
        return blocos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atividade atividade = (Atividade) o;
        return Objects.equals(id, atividade.id) && Objects.equals(nome, atividade.nome) && Objects.equals(descricao, atividade.descricao) && Objects.equals(preco, atividade.preco) && Objects.equals(blocos, atividade.blocos) && Objects.equals(categoria, atividade.categoria) && Objects.equals(participantes, atividade.participantes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao, preco, blocos, categoria, participantes);
    }

    @Override
    public String toString() {
        return "Atividade {" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", blocos=" + blocos +
                ", categoria=" + categoria +
                ", participantes=" + participantes +
                '}';
    }
}
