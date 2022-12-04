/*
@Author Bambang a.k.a. Bambang
calon menantu idaman
created with Eclipse intellij 2022.2.3
Created on 12/1/2022  2:43 PM
Last Modified on 12/1/20222:43 PM
Version 1.0
*/


package com.bcafinance.bpbspringboot.models;

import com.bcafinance.bpbspringboot.utils.ConstantMessage;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "MstSeller")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SellerId")
    private Long id;

    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
//    @Column(name = "City",length = 50,nullable = false,unique = true)
    @Column(name = "Name",length = 50,unique = true)
    private String name;

    @NotNull(message = ConstantMessage.WARNING_DATA_EMPTY)
//    @Column(name = "City",length = 50,nullable = false,unique = true)
    @Column(name = "BirthDate")
    private LocalDate birthDate;

    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    @Column(name = "Email",length = 50 ,unique = true)
    private String email;

    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    @Column(name = "PhoneNumber", length = 16, unique = true)
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "GeographyId")
    private Geographies geographies;

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

    @ManyToMany
    @JoinTable(
            name = "SellerPartners",
            joinColumns = @JoinColumn(name="SellerId",referencedColumnName = "SellerId"),
            inverseJoinColumns = @JoinColumn(name = "PartnersId",referencedColumnName = "PartnersId")
    )
    @JsonManagedReference
    private Set<Partners> partners = new HashSet<Partners>();

    public Seller(){

    }
}
