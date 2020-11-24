package com.bogdan.service.manager.parts.company.service;

import com.bogdan.service.manager.parts.company.model.Company;
import com.bogdan.service.manager.parts.company.repository.CompanyRepository;
import com.bogdan.service.manager.common.database.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyService extends CrudService<Company, CompanyRepository> {
    private final CompanyRepository companyRepository;

    @Override
    protected CompanyRepository getRepository() {
        return companyRepository;
    }
}
