package br.edu.infnet.pedidos.infra.message;

import br.edu.infnet.pedidos.eventos.EstadoPedidoMudou;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.stereotype.Service;

@Service
public class JsonMessageConverter {

    private final ObjectMapper objectMapper;

    public JsonMessageConverter() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new SimpleModule()
                .addSerializer(EstadoPedidoMudou.class, new EstadoPedidoMudouSerializer())
                .addDeserializer(EstadoPedidoMudou.class, new EstadoPedidoMudouDeserializer()));
    }

    public String toJson(EstadoPedidoMudou evento) throws JsonProcessingException {
        return objectMapper.writeValueAsString(evento);
    }

    public EstadoPedidoMudou fromJson(String json) throws JsonProcessingException {
        return objectMapper.readValue(json, EstadoPedidoMudou.class);
    }
}
