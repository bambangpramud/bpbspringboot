/*
@Author Bambang a.k.a. Bambang
calon menantu idaman
created with Eclipse intellij 2022.2.3
Created on 12/2/2022  2:06 PM
Last Modified on 12/2/20222:06 PM
Version 1.0
*/


package com.bcafinance.bpbspringboot.models;


import com.bcafinance.bpbspringboot.utils.ConstantMessage;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "MstPartners")
public class Partners {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PartnersId")
    private Long id;

    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
//    @Column(name = "City",length = 50,nullable = false,unique = true)
    @Column(name = "Name",length = 50,unique = true)
    private String name;

    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    @Column(name = "Email",length = 50 ,unique = true)
    private String email;

    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    @Column(name = "PhoneNumber", length = 16, unique = true)
    private String phoneNumber;

    @ManyToMany(mappedBy = "partners")
    @JsonBackReference
    private Set<Seller> seller = new HashSet<Seller>();

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

    public Partners(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Seller> getSeller() {
        return seller;
    }

    public void setSeller(Set<Seller> seller) {
        this.seller = seller;
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
