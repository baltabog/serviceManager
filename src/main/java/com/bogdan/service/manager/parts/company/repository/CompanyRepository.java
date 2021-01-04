package com.bogdan.service.manager.parts.company.repository;

import com.bogdan.service.manager.parts.company.model.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public interface CompanyRepository extends CrudRepository<Company, Long> {
    // no custom queries

    @Query("SELECT c " +
            "FROM Company c " +
            "WHERE c.type <> com.bogdan.service.manager.common.enums.CompanyTypeEnum.OWNER " +
            "ORDER BY c.type DESC, c.id DESC ")
    List<Company> getAllExceptOwner();
}
