package com.example.petfriends_almoxarifado.service;


import com.example.petfriends_almoxarifado.Config.RabbitMQConfig;
import com.example.petfriends_almoxarifado.Event.EstadoPedidoMudou;
import com.example.petfriends_almoxarifado.Event.PedidoStatus;
import com.example.petfriends_almoxarifado.entity.ProdutoAlmoxarifado;
import com.example.petfriends_almoxarifado.repository.ProdutoAlmoxarifadoRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class AlmoxarifadoService {

    @Autowired
    private ProdutoAlmoxarifadoRepository repository;

    @RabbitListener(queues = RabbitMQConfig.QUEUE_PEDIDOS)
    public void receberEventoEstadoPedido(EstadoPedidoMudou evento) {
        if (evento.getEstado() == PedidoStatus.EM_PREPARACAO) {
            ProdutoAlmoxarifado produto = repository.findById(evento.getIdPedido()).orElseThrow();
            produto.getQuantidadeEstoque().diminuir(BigDecimal.ONE);
            repository.save(produto);
        }
    }
}

