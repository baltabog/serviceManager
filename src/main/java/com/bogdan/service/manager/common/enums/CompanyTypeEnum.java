package com.bogdan.service.manager.common.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

public enum CompanyTypeEnum {
    OWNER("Companie"),
    SUPPLIER("Furnizor"),
    CLIENT("Client")
    ;

    @Getter
    private String roName;

    CompanyTypeEnum(String name) {
        roName = name;
    }
}
