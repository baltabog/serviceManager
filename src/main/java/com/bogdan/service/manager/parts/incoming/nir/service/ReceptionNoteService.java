package com.bogdan.service.manager.parts.incoming.nir.service;

import com.bogdan.service.manager.common.database.CrudService;
import com.bogdan.service.manager.parts.incoming.nir.model.ReceptionNote;
import com.bogdan.service.manager.parts.incoming.nir.repository.ReceptionNoteRepository;
import com.bogdan.service.manager.parts.products.stock.model.ProductStock;
import com.bogdan.service.manager.parts.products.stock.repository.ProductStockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReceptionNoteService extends CrudService<ReceptionNote, ReceptionNoteRepository> {
    private final ReceptionNoteRepository receptionNoteRepository;

    @Override
    protected ReceptionNoteRepository getRepository() {
        return receptionNoteRepository;
    }
}
