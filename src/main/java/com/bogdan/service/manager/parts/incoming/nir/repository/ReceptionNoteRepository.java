package com.bogdan.service.manager.parts.incoming.nir.repository;

import com.bogdan.service.manager.parts.incoming.nir.model.ReceptionNote;
import org.springframework.data.repository.CrudRepository;

public interface ReceptionNoteRepository extends CrudRepository<ReceptionNote, Long> {
    // no custom queries
}
