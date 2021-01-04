package com.bogdan.service.manager.parts.company.model;

import com.bogdan.service.manager.common.database.Model;
import com.bogdan.service.manager.common.enums.CompanyTypeEnum;
import com.bogdan.service.manager.parts.media.model.Media;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
@Data
public class Company implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Enumerated(EnumType.STRING)
    private CompanyTypeEnum type;
    private String name;
    private String cif;
    private String caen;
    private String cui;
    private String address;
    private String phone;
    private String email;
    private String iban;
    private String bank;
    @OneToOne
    @JoinColumn(name = "logo", referencedColumnName = "id")
    private Media logoMedia;
}
