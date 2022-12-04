/*
@Author Bambang a.k.a. Bambang
calon menantu idaman
created with Eclipse intellij 2022.2.3
Created on 11/30/2022  1:45 PM
Last Modified on 11/30/20221:45 PM
Version 1.0
*/


package com.bcafinance.bpbspringboot.models;

import com.bcafinance.bpbspringboot.utils.ConstantMessage;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@Entity
@Table(name = "MstGeography")
public class Geographies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GeographyId")
    private Long id;

    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
//    @Column(name = "City",length = 50,nullable = false,unique = true)
    @Column(name = "City",length = 50,unique = true)
    private String city;

//    @Column(name = "StateProvinceCode",length = 10,nullable = false)
@NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    @Column(name = "StateProvinceCode",length = 10)
    private String spCode;

//    @Column(name = "StateProvinceName",length = 50,nullable = false)
@NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    @Column(name = "StateProvinceName",length = 50)
    private String spName;

//    @Column(name = "StateCountryCode",length = 10,nullable = false)
@NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    @Column(name = "StateCountryCode",length = 10)
    private String scCode;

//    @Column(name = "StateCountryName",length = 50,nullable = false)
@NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    @Column(name = "StateCountryName",length = 50)
    private String scName;

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

    public Geographies() {
    }
}
