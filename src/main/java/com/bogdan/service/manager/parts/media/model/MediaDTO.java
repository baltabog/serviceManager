package com.bogdan.service.manager.parts.media.model;

import lombok.Data;
import org.springframework.http.MediaType;

@Data
public class MediaDTO  {
    private long id;
    private MediaType type;
    private String name;
    private Integer size;
}
