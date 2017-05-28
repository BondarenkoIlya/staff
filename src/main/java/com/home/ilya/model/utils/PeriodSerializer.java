package com.home.ilya.model.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.Period;

public class PeriodSerializer extends StdSerializer<Period> {
    private static final long serialVersionUID = -8728474469165904125L;

    public PeriodSerializer() {
        super(Period.class);
    }

    @Override
    public void serialize(Period period, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (period != null) {
            StringBuilder averageDuration = new StringBuilder();
            averageDuration.append(period.getYears() + " years,");
            averageDuration.append(period.getMonths() + " months,");
            averageDuration.append(period.getYears() + " days");
            jsonGenerator.writeString(averageDuration.toString());
        }
    }
}
