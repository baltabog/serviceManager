package com.bogdan.service.manager.parts.company.repository;

import com.bogdan.service.manager.parts.company.model.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, Integer> {
    // no custom queries
}
