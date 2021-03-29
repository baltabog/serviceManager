package com.bogdan.service.manager.parts.company.repository;

import com.bogdan.service.manager.parts.company.model.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends CrudRepository<Company, Long> {
    @Query("SELECT c " +
            "FROM Company c " +
            "WHERE c.type <> com.bogdan.service.manager.common.enums.CompanyTypeEnum.OWNER " +
            "ORDER BY c.type DESC, c.id DESC ")
    List<Company> getAllExceptOwner();

    @Query("SELECT c " +
            "FROM Company c " +
            "WHERE c.type = com.bogdan.service.manager.common.enums.CompanyTypeEnum.OWNER ")
    Optional<Company> getOwner();

    @Query("SELECT c " +
            "FROM Company c " +
            "WHERE c.type = com.bogdan.service.manager.common.enums.CompanyTypeEnum.SUPPLIER " +
            "ORDER BY c.name ")
    List<Company> getSuppliers();
}
