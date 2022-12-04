/*
@Author Bambang a.k.a. Bambang
calon menantu idaman
created with Eclipse intellij 2022.2.3
Created on 12/2/2022  9:38 AM
Last Modified on 12/2/20229:38 AM
Version 1.0
*/


package com.bcafinance.bpbspringboot.models;


import com.bcafinance.bpbspringboot.utils.ConstantMessage;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "MstDiscounts")
public class Discounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DiscountsId")
    private Long id;

    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
//    @Column(name = "City",length = 50,nullable = false,unique = true)
    @Column(name = "Name",length = 50,unique = true)
    private String name;

    //    @Column(name = "StateProvinceCode",length = 10,nullable = false)
    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    @Column(name = "Description",length = 225)
    private String description;

    //    @Column(name = "StateProvinceName",length = 50,nullable = false)
    @NotNull(message = ConstantMessage.WARNING_DATA_EMPTY)
//    @Column(name = "City",length = 50,nullable = false,unique = true)
    @Column(name = "StartDate")
    private LocalDate startDate;

    @NotNull(message = ConstantMessage.WARNING_DATA_EMPTY)
//    @Column(name = "City",length = 50,nullable = false,unique = true)
    @Column(name = "EndDate")
    private LocalDate endDate;

    @Column(name = "Limit")
    private Integer limit;

    @Column(name = "Cut")
    private Float cut;

    @Column(name = "CreatedBy",nullable = false)
    private String createdBy = "1";

    @Column(name = "CreatedDate",nullable = false)
    private Date createdDate = new Date();//JANGAN GUNAKAN columnDefinition untuk set default kolom, langsung set di variabel nya saja.

    @Column(name = "ModifiedBy",nullable = true)
    private String modifiedBy ;

    @Column(name = "ModifiedDate",nullable = true)
    private Date modifiedDate;

    @Column(name = "IsActive",nullable = false)
    private boolean isActive = true;
}
