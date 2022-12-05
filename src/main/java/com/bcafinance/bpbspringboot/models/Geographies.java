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
//import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSpCode() {
        return spCode;
    }

    public void setSpCode(String spCode) {
        this.spCode = spCode;
    }

    public String getSpName() {
        return spName;
    }

    public void setSpName(String spName) {
        this.spName = spName;
    }

    public String getScCode() {
        return scCode;
    }

    public void setScCode(String scCode) {
        this.scCode = scCode;
    }

    public String getScName() {
        return scName;
    }

    public void setScName(String scName) {
        this.scName = scName;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
