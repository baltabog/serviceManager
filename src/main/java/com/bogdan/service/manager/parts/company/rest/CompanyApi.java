package com.bogdan.service.manager.parts.company.rest;

import com.bogdan.service.manager.parts.company.model.Company;
import com.bogdan.service.manager.parts.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/company", produces = "application/json")
@RequiredArgsConstructor
public class CompanyApi {
    private final CompanyService companyService;

    @GetMapping("/{id}")
    public Company getCompany(@PathVariable Integer id) {
        return companyService.getById(id);
    }

    @GetMapping("/all")
    public List<Company> getCompany() {
        return companyService.getAll();
    }

    @PostMapping
    public Company createCompany(@RequestBody Company company) {
        return companyService.create(company);
    }

    @PutMapping
    public Company updateCompany(@RequestBody Company company) {
        return companyService.update(company);
    }

    @DeleteMapping("/{id}")
    public boolean updateCompany(@PathVariable Integer id) {
        return companyService.delete(id);
    }
}
