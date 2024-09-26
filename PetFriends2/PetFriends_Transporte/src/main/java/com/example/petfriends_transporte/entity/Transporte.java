package com.example.petfriends_transporte.entity;

import com.example.petfriends_transporte.event.TransporteStatus;
import com.example.petfriends_transporte.event.TransporteStatusConverter;
import com.example.petfriends_transporte.event.ValorMonetarioConverter;
import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
@Entity
public class Transporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;

    @Temporal(TemporalType.DATE)
    private Date dataEnvio;

    @Enumerated(EnumType.STRING)
    private TransporteStatus status;

    @Embedded
    private ValorMonetario valorTotal;

    public Transporte() {
        this.dataEnvio = new Date();
        this.status = TransporteStatus.PENDENTE;
        this.valorTotal = new ValorMonetario(BigDecimal.ZERO);
    }

    public Transporte(String codigo, ValorMonetario valorTotal) {
        this.codigo = codigo;
        this.dataEnvio = new Date();
        this.status = TransporteStatus.PENDENTE;
        this.valorTotal = valorTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public TransporteStatus getStatus() {
        return status;
    }

    public void setStatus(TransporteStatus status) {
        this.status = status;
    }

    public ValorMonetario getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(ValorMonetario valorTotal) {
        this.valorTotal = valorTotal;
    }
}
