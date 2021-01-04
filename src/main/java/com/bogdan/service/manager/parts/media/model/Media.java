package com.bogdan.service.manager.parts.media.model;

import com.bogdan.service.manager.common.database.Model;
import lombok.Data;
import org.springframework.http.MediaType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
public class Media implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private MediaType type;
    private String name;
    private String path;
    private Long size;
}
