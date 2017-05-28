package com.home.ilya.model.utils;

import javax.persistence.AttributeConverter;
import java.sql.Date;
import java.time.LocalDate;

public class LocalDateConverter implements AttributeConverter<LocalDate, Date> {

    /**
     * {@inheritDoc}
     **/
    @Override
    public Date convertToDatabaseColumn(LocalDate date) {
        if (date == null) {
            return null;
        }
        return Date.valueOf(date);
    }

    /**
     * {@inheritDoc}
     **/
    @Override
    public LocalDate convertToEntityAttribute(Date dbData) {
        if (dbData ==null){
            return null;
        }
        return dbData.toLocalDate();
    }
}
