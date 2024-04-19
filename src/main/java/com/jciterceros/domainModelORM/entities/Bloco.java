package com.jciterceros.domainModelORM.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_bloco")
public class Bloco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant inicio;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant fim;
    @ManyToOne //Um Bloco pertence a uma Atividade
    private Atividade atividades;

    public Bloco() {
    }

    public Bloco(Integer id, Instant inicio, Instant fim, Atividade atividades) {
        this.id = id;
        this.inicio = inicio;
        this.fim = fim;
        this.atividades = atividades;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getInicio() {
        return inicio;
    }

    public void setInicio(Instant inicio) {
        this.inicio = inicio;
    }

    public Instant getFim() {
        return fim;
    }

    public void setFim(Instant fim) {
        this.fim = fim;
    }

    public Atividade getAtividades() {
        return atividades;
    }

    public void setAtividades(Atividade atividades) {
        this.atividades = atividades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bloco bloco = (Bloco) o;
        return Objects.equals(id, bloco.id) && Objects.equals(inicio, bloco.inicio) && Objects.equals(fim, bloco.fim) && Objects.equals(atividades, bloco.atividades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, inicio, fim, atividades);
    }

    @Override
    public String toString() {
        return "Bloco {" +
                "id=" + id +
                ", inicio=" + inicio +
                ", fim=" + fim +
                ", atividades=" + atividades +
                '}';
    }
}
