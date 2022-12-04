/*
@Author Bambang a.k.a. Bambang
calon menantu idaman
created with Eclipse intellij 2022.2.3
Created on 12/2/2022  2:13 PM
Last Modified on 12/2/20222:13 PM
Version 1.0
*/


package com.bcafinance.bpbspringboot.dto;

import com.bcafinance.bpbspringboot.models.Geographies;
import com.bcafinance.bpbspringboot.models.Partners;
import com.bcafinance.bpbspringboot.utils.ConstantMessage;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class SellerDTO {

    private Long id;

    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    private String name;

    @NotNull(message = ConstantMessage.WARNING_DATA_EMPTY)
    private LocalDate birthDate;

    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)

    private String email;

    private String phoneNumber;


    private Geographies geographies;



    private Set<Partners> partners = new HashSet<Partners>();

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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
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

    public Geographies getGeographies() {
        return geographies;
    }

    public void setGeographies(Geographies geographies) {
        this.geographies = geographies;
    }

    public Set<Partners> getPartners() {
        return partners;
    }

    public void setPartners(Set<Partners> partners) {
        this.partners = partners;
    }
}
