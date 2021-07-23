package br.com.zupacademy.gabrielbrandao.casadocodigo.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    private LocalDateTime dataCriacao;

    public Aluno(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        dataCriacao = LocalDateTime.now();
    }
}
