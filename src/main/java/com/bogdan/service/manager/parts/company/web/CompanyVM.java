package com.bogdan.service.manager.parts.company.web;

import com.bogdan.service.manager.common.enums.CompanyTypeEnum;
import com.bogdan.service.manager.parts.company.model.Company;
import com.bogdan.service.manager.parts.company.service.CompanyService;
import lombok.Getter;
import lombok.Setter;
import org.zkoss.bind.annotation.Command;
import org.zkoss.spring.init.CoreVariableResolver;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import java.util.Arrays;
import java.util.List;

@VariableResolver(CoreVariableResolver.class)
public class CompanyVM {

    @WireVariable
    CompanyService companyService;

    @Getter
    @Setter
    private Company company;

    public List<Company> getCompanies() {
        return companyService.getAllExceptOwner();
    }

    public List<CompanyTypeEnum> getCompanyTypeModel() {
        return Arrays.asList(CompanyTypeEnum.SUPPLIER, CompanyTypeEnum.CLIENT);
    }

    @Command
    public void onSelectCompany() {
        // do nothing
    }

}
