package com.bogdan.service.manager.parts.company.service;

import com.bogdan.service.manager.parts.company.model.Company;
import com.bogdan.service.manager.parts.company.repository.CompanyRepository;
import com.bogdan.service.manager.common.database.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService extends CrudService<Company, CompanyRepository> {
    private final CompanyRepository companyRepository;

    @Override
    protected CompanyRepository getRepository() {
        return companyRepository;
    }

    public List<Company> getAllExceptOwner() {
        return companyRepository.getAllExceptOwner();
    }

    public Optional<Company> getOwner() {
        return companyRepository.getOwner();
    }

    public List<Company> getSuppliers() {
        return companyRepository.getSuppliers();
    }
}
