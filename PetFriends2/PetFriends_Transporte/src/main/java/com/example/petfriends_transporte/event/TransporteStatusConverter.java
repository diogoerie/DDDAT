package com.example.petfriends_transporte.event;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;


@Converter(autoApply = true)
public class TransporteStatusConverter implements AttributeConverter<TransporteStatus, String> {

    @Override
    public String convertToDatabaseColumn(TransporteStatus status) {
        return status.toString();
    }

    @Override
    public TransporteStatus convertToEntityAttribute(String dbData) {
        return TransporteStatus.valueOf(dbData);
    }
}


