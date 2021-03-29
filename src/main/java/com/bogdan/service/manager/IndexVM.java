package com.bogdan.service.manager;

import com.bogdan.service.manager.parts.company.service.CompanyService;
import lombok.Getter;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.spring.init.CoreVariableResolver;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

@VariableResolver(CoreVariableResolver.class)
public class IndexVM {
    @WireVariable
    private CompanyService companyService;
    @Getter
    private String content = "~./view/company/ownerCompany.zul";

    @Command
    @NotifyChange("content")
    public void showView(@BindingParam("view") String view) {
        if (companyService.getOwner().isPresent()) {
            content = view;
        }
    }
}
