package com.bogdan.service.manager.parts.company.web;

import com.bogdan.service.manager.common.enums.CompanyTypeEnum;
import com.bogdan.service.manager.parts.company.model.Company;
import com.bogdan.service.manager.parts.company.service.CompanyService;
import lombok.Getter;
import lombok.Setter;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.spring.init.CoreVariableResolver;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@VariableResolver(CoreVariableResolver.class)
public class OwnerCompanyVM {
    @WireVariable
    private CompanyService companyService;
    @Getter
    @Setter
    private Company company;
    @Getter
    private boolean editDisabled = false;

    @Init
    public void init() {
        Optional<Company> dbOwner = companyService.getOwner();

        if (dbOwner.isPresent()) {
            company = dbOwner.get();
            return;
        }

        company = new Company();
        company.setType(CompanyTypeEnum.OWNER);
    }

    public List<CompanyTypeEnum> getCompanyTypeModel() {
        return Arrays.asList(CompanyTypeEnum.OWNER);
    }

    @Command
    public void saveCompany() {
        if (company.getId() > 0) {
            companyService.update(company);
        } else {
            companyService.create(company);
        }
    }
}
