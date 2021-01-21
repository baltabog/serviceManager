package com.bogdan.service.manager.parts.company.web;

import com.bogdan.service.manager.common.enums.CompanyTypeEnum;
import com.bogdan.service.manager.parts.company.model.Company;
import com.bogdan.service.manager.parts.company.service.CompanyService;
import lombok.Getter;
import lombok.Setter;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.spring.init.CoreVariableResolver;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import java.util.Arrays;
import java.util.List;

@VariableResolver(CoreVariableResolver.class)
public class CompanyManagerVM {

    @WireVariable
    private CompanyService companyService;

    @Getter
    @Setter
    private Company company;

    private boolean enableEdit = false;

    public List<Company> getCompanies() {
        return companyService.getAllExceptOwner();
    }

    public List<CompanyTypeEnum> getCompanyTypeModel() {
        return Arrays.asList(CompanyTypeEnum.SUPPLIER, CompanyTypeEnum.CLIENT);
    }

    @Command
    @NotifyChange({"company", "editDisabled"})
    public void onSelectCompany() {
        enableEdit = false;
    }

    @Command
    @NotifyChange({"company", "editDisabled"})
    public void onEdit(@BindingParam("company") Company companySelected) {
        enableEdit = true;
        company = companySelected;
    }

    @Command
    @NotifyChange("companies")
    public void onDelete(@BindingParam("company") Company companySelected) {
        companyService.delete(companySelected.getId());
    }

    @Command
    @NotifyChange({"company", "editDisabled"})
    public void addCompany() {
        enableEdit = true;
        company = new Company();
    }

    @Command
    @NotifyChange({"companies", "editDisabled"})
    public void saveCompany() {
        enableEdit = false;
        if (company.getId() > 0) {
            companyService.update(company);
        } else {
            companyService.create(company);
        }
    }

    public boolean isEditDisabled(){
        return !enableEdit;
    }

}
