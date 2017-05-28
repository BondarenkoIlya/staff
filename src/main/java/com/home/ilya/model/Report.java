package com.home.ilya.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.home.ilya.model.utils.LocalDateSerializer;
import com.home.ilya.model.utils.PeriodSerializer;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Report extends BaseEntity {
    private static final long serialVersionUID = -3143850725147845601L;

    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate reportCreationDate;

    @JsonSerialize(using = PeriodSerializer.class)
    private Period averageWorkDurationInCompany;
}
