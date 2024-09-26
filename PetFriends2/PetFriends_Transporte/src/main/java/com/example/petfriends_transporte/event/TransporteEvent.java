package com.example.petfriends_transporte.event;


import java.io.Serializable;
import java.util.Date;

public class TransporteEvent implements Serializable {

    private Long idTransporte;
    private TransporteStatus status;
    private Date dataEvento;

    public TransporteEvent(Long idTransporte, TransporteStatus status) {
        this.idTransporte = idTransporte;
        this.status = status;
        this.dataEvento = new Date();
    }

    public Long getIdTransporte() {
        return idTransporte;
    }

    public TransporteStatus getStatus() {
        return status;
    }

    public Date getDataEvento() {
        return dataEvento;
    }
}

