package com.example.petfriends_almoxarifado.entity;



import jakarta.persistence.Embeddable;

import java.math.BigDecimal;


@Embeddable
public class QuantidadeEstoque {

    private BigDecimal quantidade;

    public QuantidadeEstoque() {

    }

    public QuantidadeEstoque(BigDecimal quantidade) {
        if (quantidade.signum() < 0) {
            throw new IllegalArgumentException("Essa quantidade não pode ser negativa");
        }
        this.quantidade = quantidade;
    }
    public void aumentar(BigDecimal valor) {
        this.quantidade = this.quantidade.add(valor);
    }

    public void diminuir(BigDecimal valor) {
        this.quantidade = this.quantidade.subtract(valor);
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }
}

