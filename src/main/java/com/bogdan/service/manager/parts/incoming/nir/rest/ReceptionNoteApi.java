package com.bogdan.service.manager.parts.incoming.nir.rest;

import com.bogdan.service.manager.common.api.CrudAPI;
import com.bogdan.service.manager.parts.company.model.Company;
import com.bogdan.service.manager.parts.company.repository.CompanyRepository;
import com.bogdan.service.manager.parts.company.service.CompanyService;
import com.bogdan.service.manager.parts.incoming.nir.model.ReceptionNote;
import com.bogdan.service.manager.parts.incoming.nir.repository.ReceptionNoteRepository;
import com.bogdan.service.manager.parts.incoming.nir.service.ReceptionNoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest/api/nir", produces = "application/json")
@RequiredArgsConstructor
public class ReceptionNoteApi extends CrudAPI<ReceptionNote, ReceptionNoteRepository, ReceptionNoteService> {
    private final ReceptionNoteService receptionNoteService;

    @Override
    protected ReceptionNoteService getService() {
        return receptionNoteService;
    }
}
