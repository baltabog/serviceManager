package com.bogdan.service.manager.parts.company.model;

import com.bogdan.service.manager.common.database.Model;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
public class Company extends Model {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private CompanyTypeEnum type;
    private String name;
    private String cif;
    private String caen;
    private String cui;
    @Column(name = "registration_number")
    private String registrationNumber;
    private String address;
    private String phone;
    private String email;
    @Column(name = "logo_path")
    private String logoPath;
}
