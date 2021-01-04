package com.bogdan.service.manager.parts.products.def.model;

import com.bogdan.service.manager.common.database.Model;
import com.bogdan.service.manager.common.enums.MeasurementEnum;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class ProductDefinition implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private MeasurementEnum measurement;
    private String categories;

    // add more general info
}
