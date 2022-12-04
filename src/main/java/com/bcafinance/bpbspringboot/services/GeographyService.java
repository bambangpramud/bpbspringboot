/*
@Author Bambang a.k.a. Bambang
calon menantu idaman
created with Eclipse intellij 2022.2.3
Created on 11/30/2022  1:45 PM
Last Modified on 11/30/20221:45 PM
Version 1.0
*/


package com.bcafinance.bpbspringboot.services;



import com.bcafinance.bpbspringboot.handler.FormatValidation;
import com.bcafinance.bpbspringboot.handler.ResourceNotFoundException;
import com.bcafinance.bpbspringboot.models.Geographies;
import com.bcafinance.bpbspringboot.repos.GeographyRepo;
import com.bcafinance.bpbspringboot.utils.ConstantMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GeographyService {

    private GeographyRepo georepo;

    @Autowired
    public GeographyService(GeographyRepo georepo) {
        this.georepo = georepo;
    }

    public List<Geographies> findAllGeographies(){
    return georepo.findAll();

    }


    public Geographies findById(Long id) throws Exception{
        return georepo.findById(id).
                orElseThrow(() -> new ResourceNotFoundException(ConstantMessage.WARNING_NOT_FOUND));
    }

    public Optional<Geographies> findByCity(String city){
        return georepo.findByCity(city);
    }

    public List<Geographies> searchByProvinceNameEndsWith(String province){
        return georepo.findBySpNameEndsWith(province);
    }

    public List<Geographies> searchByProvinceNameStartsWith(String province){
        return georepo.findBySpNameStartsWith(province);
    }

    public  List<Geographies> searchByStateCountryName(String country){
        return georepo.searchByScName(country);
    }

    public List<Geographies> findByCityNotlike(String city){
        return georepo.findByCityNotContainsIgnoreCase(city);
    }

    public List<Geographies> findByCitylike(String city){
        return georepo.findByCityContainsIgnoreCase(city);
    }

    public void saveGeography(Geographies geography) throws Exception{
        if(geography.getSpCode()==null)throw new DataIntegrityViolationException(ConstantMessage.ERROR_DATA_INVALID);
        if(geography.getScCode()==null)throw new DataIntegrityViolationException(ConstantMessage.ERROR_DATA_INVALID);
        if(geography.getSpName()==null)throw new DataIntegrityViolationException(ConstantMessage.ERROR_DATA_INVALID);
        if(geography.getScName()==null)throw new DataIntegrityViolationException(ConstantMessage.ERROR_DATA_INVALID);
        if(geography.getCity()==null)throw new DataIntegrityViolationException(ConstantMessage.ERROR_DATA_INVALID);


        FormatValidation.stateCodeValidation(geography.getScCode());
        FormatValidation.stateCodeValidation(geography.getSpCode());
        FormatValidation.noRussiaValidation(geography.getScName());

        georepo.save(geography);
    }

//    @Transactional(rollbackFor = {Exception.class})

    @Transactional(rollbackFor = {Exception.class})
    public  void updateGeography(Geographies geo) throws Exception{

        Geographies geography = georepo.findById(geo.getId()).orElseThrow(()->
                new ResourceNotFoundException(ConstantMessage.WARNING_GEOGRAPHY_NOT_FOUND));

        geography.setModifiedBy("1");
        geography.setModifiedDate(new Date());
        if (geo.getSpCode() !=null && !geo.getSpCode().equals(""))
        {
            FormatValidation.stateCodeValidation(geography.getSpCode());
            geography.setSpCode(geo.getSpCode());
        }
        if (geo.getScCode() !=null && !geo.getScCode().equals(""))
        {
            FormatValidation.stateCodeValidation(geography.getScCode());
            geography.setScCode(geo.getScCode());
        }

        if (geo.getSpName() !=null && !geo.getSpName().equals(""))
        {
            geography.setSpName(geo.getSpName());
        }
        if (geo.getScName() !=null && !geo.getScName().equals(""))
        {
            FormatValidation.noRussiaValidation(geography.getScName());
            geography.setScName(geo.getScName());
        }
        if (geo.getCity() !=null && !geo.getCity().equals(""))
        {
            geography.setCity(geo.getCity());
        }

//        georepo.save(geography);
    }

    @Transactional(rollbackFor = {Exception.class})
    public void saveAllGeography(List<Geographies> geos){
        georepo.saveAll(geos);
    }




}
