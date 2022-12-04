/*
@Author Bambang a.k.a. Bambang
calon menantu idaman
created with Eclipse intellij 2022.2.3
Created on 11/30/2022  1:46 PM
Last Modified on 11/30/20221:46 PM
Version 1.0
*/


package com.bcafinance.bpbspringboot.controllers;
import com.bcafinance.bpbspringboot.dto.GeographyDTO;
import com.bcafinance.bpbspringboot.handler.ResourceNotFoundException;
import com.bcafinance.bpbspringboot.handler.ResponseHandler;
import com.bcafinance.bpbspringboot.models.Geographies;

import com.bcafinance.bpbspringboot.services.GeographyService;
import com.bcafinance.bpbspringboot.utils.ConstantMessage;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/")
public class GeographyController {

    @Getter
    private GeographyService geoserv;

    public GeographyController(){}

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    public GeographyController(GeographyService geoserv) {
        this.geoserv = geoserv;
    }

    @PostMapping("/v1/geography")
    public ResponseEntity<Object>
    saveGeography(@Valid @RequestBody Geographies geography) throws Exception {


        if(geography==null)throw new ResourceNotFoundException(ConstantMessage.ERROR_NO_CONTENT);
        geoserv.saveGeography(geography);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED,null,null,null);
    }

    @PostMapping("/v1/geography/saveall")
    public ResponseEntity<Object>
    saveAllGeographies(@Valid @RequestBody List<Geographies> geography) throws Exception {


        if(geography==null)throw new ResourceNotFoundException(ConstantMessage.ERROR_NO_CONTENT);
        geoserv.saveAllGeography(geography);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED,null,null,null);
    }


    @GetMapping("/v1/geography/{id}")
    public ResponseEntity<Object> getGeographyById(@PathVariable("id") long id) throws Exception {
        Geographies geo = geoserv.findById(id);


        if(geo != null)
        {
                GeographyDTO geoDTO = modelMapper.map(geo,GeographyDTO.class);

            return new ResponseHandler().
                    generateResponse(ConstantMessage.SUCCESS_FIND_BY, HttpStatus.OK,geoDTO,null,null);
        }
        else
        {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_NOT_FOUND);
        }
    }

    @GetMapping("/v1/geography/datas/all/0")
    public ResponseEntity<Object> findAllGeographies()throws Exception{


        int data = 0;
        List<Geographies> lsGeographies = geoserv.findAllGeographies();

        if(lsGeographies.size()==0)
        {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_DATA_EMPTY);
        }

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,lsGeographies,null,null);
    }

    @GetMapping("/v1/geography/datas/dto/all/0")
    public ResponseEntity<Object> findAllGeographiesDTO()throws Exception{


        List<Geographies> lsGeo = geoserv.findAllGeographies();

        if(lsGeo.size()==0)
        {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_DATA_EMPTY);
        }

        List<GeographyDTO> lsGeographyDTO = modelMapper.map(lsGeo,new TypeToken<List<GeographyDTO>>() {}.getType());



        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,lsGeographyDTO,null,null);


    }

    @GetMapping("/v1/geography/datas/search/{city}")
    public ResponseEntity<Object> getGeographyByCity(@PathVariable("city") String city)throws Exception{


        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,geoserv.findByCity(city),null,null);

    }

    @PutMapping("/v1/geography/upd")
    public ResponseEntity<Object> updateGeographyByID(@RequestBody Geographies geo)throws Exception{
        geoserv.updateGeography(geo);
        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,"",null,null);
    }

    @GetMapping("/v1/geography/province/end/{name}")
    public ResponseEntity<Object> findGeographiesByProvinceNameEndsWith(@PathVariable("name") String name)throws Exception{

        List<Geographies> lsGeo = geoserv.searchByProvinceNameEndsWith(name);

        if(lsGeo.size()==0)
        {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_DATA_EMPTY);
        }

        List<GeographyDTO> lsGeographyDTO = modelMapper.map(lsGeo,new TypeToken<List<GeographyDTO>>() {}.getType());



        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,lsGeographyDTO,null,null);

    }
    @GetMapping("/v1/geography/province/start/{name}")
    public ResponseEntity<Object> findGeographiesByProvinceNameStartsWith(@PathVariable("name") String name)throws Exception{

        List<Geographies> lsGeo = geoserv.searchByProvinceNameStartsWith(name);

        if(lsGeo.size()==0)
        {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_DATA_EMPTY);
        }

        List<GeographyDTO> lsGeographyDTO = modelMapper.map(lsGeo,new TypeToken<List<GeographyDTO>>() {}.getType());



        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,lsGeographyDTO,null,null);
    }

//    @GetMapping("/v1/geography/country/{name}")
//    public ResponseEntity<Object> searchByStateCountryLike(@PathVariable("name") String name)throws Exception{
//
//        int data = 0;
//        List<Geographies> lsGeographies = geoserv.searchByStateCountryName(name);
//
//        if(lsGeographies.size()==0)
//        {
//            throw new ResourceNotFoundException(ConstantMessage.WARNING_DATA_EMPTY);
//        }
//
////        return null;
//        return new ResponseHandler().
//                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,lsGeographies,null,null);
//    }

//    @GetMapping("/v1/geography/notlike/{city}")
//    public ResponseEntity<Object> findGeographyByNotLikeCity(@PathVariable("city") String city)throws Exception{
//
//        int data = 0;
//        List<Geographies> lsGeographies = geoserv.findByCityNotlike(city);
//
//        if(lsGeographies.size()==0)
//        {
//            throw new ResourceNotFoundException(ConstantMessage.WARNING_DATA_EMPTY);
//        }
//
//        return new ResponseHandler().
//                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,lsGeographies,null,null);
//    }
//
//    @GetMapping("/v1/geography/like/{city}")
//    public ResponseEntity<Object> findGeographyByLikeCity(@PathVariable("city") String city)throws Exception{
//
//        int data = 0;
//        List<Geographies> lsGeographies = geoserv.findByCitylike(city);
//
//        if(lsGeographies.size()==0)
//        {
//            throw new ResourceNotFoundException(ConstantMessage.WARNING_DATA_EMPTY);
//        }
//
//        return new ResponseHandler().
//                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,lsGeographies,null,null);
//    }



}
