package com.bogdan.service.manager.parts.media.repository;

import com.bogdan.service.manager.parts.media.model.Media;
import org.springframework.data.repository.CrudRepository;

public interface MediaRepository extends CrudRepository<Media, Long> {
    // no custom queries
}
