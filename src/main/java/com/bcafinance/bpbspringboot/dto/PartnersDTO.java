/*
@Author Bambang a.k.a. Bambang
calon menantu idaman
created with Eclipse intellij 2022.2.3
Created on 12/3/2022  7:45 PM
Last Modified on 12/3/20227:45 PM
Version 1.0
*/


package com.bcafinance.bpbspringboot.dto;

import com.bcafinance.bpbspringboot.models.Seller;
import com.bcafinance.bpbspringboot.utils.ConstantMessage;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

public class PartnersDTO {

    private Long id;

    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    private String name;

    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    private String email;

    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    private String phoneNumber;

    private Set<Seller> seller = new HashSet<Seller>();

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
}
