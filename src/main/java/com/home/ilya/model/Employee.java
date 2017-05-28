package com.home.ilya.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.home.ilya.model.utils.LocalDateConverter;
import com.home.ilya.model.utils.LocalDateDeserializer;
import com.home.ilya.model.utils.LocalDateSerializer;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "employees")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Employee extends BaseEntity {
    private static final long serialVersionUID = 3441029876187600335L;

    @Embedded
    private FullName fullName;

    @Column(name ="position")
    private String position;

    @Column(name ="department")
    private String department;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @Column(name ="employment_date")
    @Convert(converter = LocalDateConverter.class)
    private LocalDate employmentDate;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @Column(name ="fired_date")
    @Convert(converter = LocalDateConverter.class)
    private LocalDate firedDate;

}
