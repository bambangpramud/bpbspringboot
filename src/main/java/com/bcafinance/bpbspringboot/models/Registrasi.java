/*
@Author Bambang a.k.a. Bambang
calon menantu idaman
created with Eclipse intellij 2022.2.3
Created on 12/4/2022  4:58 PM
Last Modified on 12/4/20224:58 PM
Version 1.0
*/


package com.bcafinance.bpbspringboot.models;

import com.bcafinance.bpbspringboot.utils.ConstantMessage;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "MstRegistrasi")
public class Registrasi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmailsID")
    private Long id;

    @NotEmpty(message = ConstantMessage.WARNING_EMAIL_MENDATORY)
    @Column(name = "Email",nullable = false)
    private String emails;

    @Column(name = "BirthDate",nullable = false)
    private LocalDate birthDate = LocalDate.now();

    @Column(name = "Username",nullable = false)
    private Boolean isCakep;

    @Column(name = "Token",nullable = true)
    private String token;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate dateRegister) {
        this.birthDate = dateRegister;
    }

    public Boolean getIsCakep() {
        return isCakep;
    }

    public void setIsCakep(Boolean username) {
        this.isCakep = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int size() {
        return 1;
    }
}

