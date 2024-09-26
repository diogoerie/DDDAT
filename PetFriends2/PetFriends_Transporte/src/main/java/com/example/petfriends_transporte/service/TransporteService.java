package com.example.petfriends_transporte.service;


import com.example.petfriends_transporte.config.RabbitMQConfig;
import com.example.petfriends_transporte.entity.Transporte;
import com.example.petfriends_transporte.entity.ValorMonetario;
import com.example.petfriends_transporte.event.TransporteEvent;
import com.example.petfriends_transporte.event.TransporteStatus;
import com.example.petfriends_transporte.repository.TransporteRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransporteService {

    @Autowired
    private TransporteRepository repository;

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void receberEventoTransporte(TransporteEvent evento) {
        if (evento.getStatus() == TransporteStatus.PENDENTE) {
            Transporte transporte = repository.findById(evento.getIdTransporte()).orElseThrow();
            transporte.getValorTotal().diminuir(new BigDecimal("100.00"));
            repository.save(transporte);
        }
    }
}
