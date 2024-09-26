package br.edu.infnet.pedidos.infra.service;

import br.edu.infnet.config.RabbitMQConfig;
import br.edu.infnet.pedidos.domain.Pedido;
import br.edu.infnet.pedidos.eventos.EstadoPedidoMudou;
import br.edu.infnet.pedidos.infra.repository.PedidoRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public Pedido obterPorId(long id) {
        return repository.findById(id).orElse(null);
    }

    public Pedido fecharPedido(long id) {
        Pedido pedido = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado"));
        pedido.fecharPedido();
        repository.save(pedido);

        EstadoPedidoMudou evento = new EstadoPedidoMudou(pedido.getId(), pedido.getStatus());
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY, evento);

        return pedido;
    }
}
