package com.bogdan.service.manager.parts.company.rest;

import com.bogdan.service.manager.common.api.CrudAPI;
import com.bogdan.service.manager.parts.company.model.Company;
import com.bogdan.service.manager.parts.company.repository.CompanyRepository;
import com.bogdan.service.manager.parts.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/rest/api/company", produces = "application/json")
@RequiredArgsConstructor
public class CompanyApi extends CrudAPI<Company, CompanyRepository, CompanyService> {
    private final CompanyService companyService;

    @Override
    protected CompanyService getService() {
        return companyService;
    }
}
