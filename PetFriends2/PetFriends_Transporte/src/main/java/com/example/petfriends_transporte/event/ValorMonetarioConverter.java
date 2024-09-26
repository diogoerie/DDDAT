package com.example.petfriends_transporte.event;

import com.example.petfriends_transporte.entity.ValorMonetario;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.math.BigDecimal;

@Converter(autoApply = true)
public class ValorMonetarioConverter implements AttributeConverter<ValorMonetario, BigDecimal> {

    @Override
    public BigDecimal convertToDatabaseColumn(ValorMonetario valorMonetario) {
        return valorMonetario.getValor();
    }

    @Override
    public ValorMonetario convertToEntityAttribute(BigDecimal quantia) {
        return new ValorMonetario(quantia);
    }
}