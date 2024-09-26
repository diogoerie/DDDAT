package com.example.petfriends_almoxarifado.Config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {
    public static final String QUEUE_PEDIDOS = "pedidos_queue";
    public static final String EXCHANGE_PEDIDOS = "pedidos_exchange";
    public static final String ROUTING_KEY_PEDIDOS = "pedidos_routingKey";

    @Bean
    public Queue pedidosQueue() {
        return new Queue(QUEUE_PEDIDOS, false);
    }

    @Bean
    public TopicExchange pedidosExchange() {
        return new TopicExchange(EXCHANGE_PEDIDOS);
    }

    @Bean
    public Binding pedidosBinding(Queue pedidosQueue, TopicExchange pedidosExchange) {
        return BindingBuilder.bind(pedidosQueue).to(pedidosExchange).with(ROUTING_KEY_PEDIDOS);
    }
}

