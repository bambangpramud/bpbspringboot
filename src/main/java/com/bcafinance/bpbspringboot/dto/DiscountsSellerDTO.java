/*
@Author Bambang a.k.a. Bambang
calon menantu idaman
created with Eclipse intellij 2022.2.3
Created on 12/2/2022  9:52 AM
Last Modified on 12/2/20229:52 AM
Version 1.0
*/


package com.bcafinance.bpbspringboot.dto;

import com.bcafinance.bpbspringboot.utils.ConstantMessage;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class DiscountsSellerDTO {


    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    private String name;


    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    private String description;


    @NotNull(message = ConstantMessage.WARNING_DATA_EMPTY)

    private LocalDate startDate;

    @NotNull(message = ConstantMessage.WARNING_DATA_EMPTY)
    private LocalDate endDate;


    private Integer limit;


    private Float cut;
}
