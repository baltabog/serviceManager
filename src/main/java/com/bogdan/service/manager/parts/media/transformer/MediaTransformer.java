package com.bogdan.service.manager.parts.media.transformer;

import com.bogdan.service.manager.parts.media.model.Media;
import com.bogdan.service.manager.parts.media.model.MediaDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "Spring", uses = Component.class)
public interface MediaTransformer {
    Media fromDTOToEntity(MediaDTO dto);

    @InheritInverseConfiguration
    MediaDTO fromEntityToDTO(Media entity);

    List<MediaDTO> fromListOfEntityToDTO(List<Media> entityList);
}
