package com.example.petfriends_almoxarifado.Event;

import java.io.Serializable;
import java.util.Date;

public class EstadoPedidoMudou implements Serializable {

    private Long idPedido;
    private PedidoStatus estado;
    private Date momento;

    public EstadoPedidoMudou(Long idPedido, PedidoStatus estado, Date momento) {
        this.idPedido = idPedido;
        this.estado = estado;
        this.momento = momento;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public PedidoStatus getEstado() {
        return estado;
    }

    public void setEstado(PedidoStatus estado) {
        this.estado = estado;
    }

    public Date getMomento() {
        return momento;
    }

    public void setMomento(Date momento) {
        this.momento = momento;
    }
}