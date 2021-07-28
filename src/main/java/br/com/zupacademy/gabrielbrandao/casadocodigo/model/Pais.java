package br.com.zupacademy.gabrielbrandao.casadocodigo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "pais")
    private List<Estado> estados;

    @Deprecated
    public Pais() {}

    public Pais(String nome) {
        this.nome = nome;
        this.estados = new ArrayList<>();
    }

    public void adicionaEstado(Estado estado) {
        this.estados.add(estado);
    }

    public boolean temEstados() {
        return !estados.isEmpty();
    }
}
