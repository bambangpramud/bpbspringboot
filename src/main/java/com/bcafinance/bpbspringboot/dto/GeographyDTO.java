/*
@Author Bambanng a.k.a. Bambang
calon menantu idaman
created with Eclipse intellij 2022.2.3
Created on 12/2/2022  2:48 PM
Last Modified on 12/2/20222:48 PM
Version 1.0
*/


package com.bcafinance.bpbspringboot.dto;

import com.bcafinance.bpbspringboot.utils.ConstantMessage;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

public class GeographyDTO {

    private Long id;

    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
//    @Column(name = "City",length = 50,nullable = false,unique = true)
    private String city;

    //    @Column(name = "StateProvinceCode",length = 10,nullable = false)
    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    private String spCode;

    //    @Column(name = "StateProvinceName",length = 50,nullable = false)
    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    private String spName;

    //    @Column(name = "StateCountryCode",length = 10,nullable = false)
    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    private String scCode;

    //    @Column(name = "StateCountryName",length = 50,nullable = false)
    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    private String scName;

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
}
