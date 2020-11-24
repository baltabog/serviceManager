package com.bogdan.service.manager.parts.company.viewController;

import com.bogdan.service.manager.common.Utils;
import com.bogdan.service.manager.parts.company.model.Company;
import com.bogdan.service.manager.parts.company.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyRepository companyRepository;

    @GetMapping("/company/list")
    public String getCompanies(Model model) {
        Iterable<Company> companies = companyRepository.findAll();
        List<Company> companyList = Utils.iteratorToList(companies);

        model.addAttribute("companies", companyList);
        return "company/list.htm";
    }
}
