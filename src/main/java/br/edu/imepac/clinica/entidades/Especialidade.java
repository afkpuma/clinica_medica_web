package br.edu.imepac.clinica.entidades;

public class Especialidade {
    private Long id;
    private String nome;
    private String descricao;

    // Constructor vazio
    public Especialidade() {
    }

    // Construtor utilitario
    public Especialidade(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
