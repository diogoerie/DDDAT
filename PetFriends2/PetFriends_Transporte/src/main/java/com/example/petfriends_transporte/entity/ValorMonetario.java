package com.example.petfriends_transporte.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

@Embeddable
public class ValorMonetario {

    private BigDecimal valor;

    public ValorMonetario() {
    }

    public ValorMonetario(BigDecimal valor) {
        if (valor.signum() < 0) {
            throw new IllegalArgumentException("Valor não pode ser negativo.");
        }
        this.valor = valor.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void aumentar(BigDecimal valorAdicional) {
        this.valor = this.valor.add(valorAdicional);
    }

    public void diminuir(BigDecimal valorSubtracao) {
        this.valor = this.valor.subtract(valorSubtracao);
    }
}
