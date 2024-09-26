package com.example.petfriends_almoxarifado.entity;


import jakarta.persistence.*;

@Entity
public class ProdutoAlmoxarifado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String codigo;



    @Embedded
    private QuantidadeEstoque quantidadeEstoque;

    public ProdutoAlmoxarifado() {

    }

    public ProdutoAlmoxarifado(String nome, String codigo, QuantidadeEstoque quantidadeEstoque) {
        this.nome = nome;
        this.codigo = codigo;
        this.quantidadeEstoque = quantidadeEstoque;
    }
    public QuantidadeEstoque getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(QuantidadeEstoque quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
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
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

}

