/*
@Author Bambang a.k.a. Bambang
calon menantu idaman
created with Eclipse intellij 2022.2.3
Created on 12/2/2022  9:40 AM
Last Modified on 12/2/20229:40 AM
Version 1.0
*/


package com.bcafinance.bpbspringboot.dto;

import com.bcafinance.bpbspringboot.utils.ConstantMessage;

import javax.persistence.Column;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class DiscountsCustomerDTO {

    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    private String name;

    @NotNull(message = ConstantMessage.WARNING_DATA_EMPTY)
    private LocalDate endDate;

    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    private String cut;

    public void setName(String name) {
        this.name = name;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setCut(Float cut) {
        String cutt=(cut*100)+"";
        this.cut = cutt.substring(0,2)+"%";
    }

    public String getName() {
        return name;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getCut() {
        return cut;
    }
}
