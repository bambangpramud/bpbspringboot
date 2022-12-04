/*
@Author Bambang a.k.a. Bambang
calon menantu idaman
created with Eclipse intellij 2022.2.3
Created on 12/2/2022  9:39 AM
Last Modified on 12/2/20229:39 AM
Version 1.0
*/


package com.bcafinance.bpbspringboot.controllers;

import com.bcafinance.bpbspringboot.dto.DiscountsCustomerDTO;
import com.bcafinance.bpbspringboot.handler.ResourceNotFoundException;
import com.bcafinance.bpbspringboot.handler.ResponseHandler;
import com.bcafinance.bpbspringboot.models.Discounts;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.TypeToken;
import com.bcafinance.bpbspringboot.services.DiscountService;

import com.bcafinance.bpbspringboot.utils.ConstantMessage;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/")
public class DiscountsController {

    @Getter
    private DiscountService discserv;

    public DiscountsController(){}

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public DiscountsController(DiscountService discserv) {
        this.discserv = discserv;
    }

    @PostMapping("/v1/discount")
    public ResponseEntity<Object>
    saveGeography(@Valid @RequestBody Discounts discounts) throws Exception {


        if(discounts==null)throw new ResourceNotFoundException(ConstantMessage.ERROR_NO_CONTENT);
        discserv.saveDiscounts(discounts);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED,null,null,null);
    }

    @GetMapping("/v1/discounts/datas/customer/0")
    public ResponseEntity<Object> findAllDiscountsCustomer()throws Exception{

        int data = 0;
        List<Discounts> lsDiscounts = discserv.findAllDiscounts();

        if(lsDiscounts.size()==0)
        {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_DATA_EMPTY);
        }


//        TypeMap<Discounts, DiscountsCustomerDTO> propertyMapper = modelMapper.createTypeMap(Discounts.class, DiscountsCustomerDTO.class);
//        propertyMapper.addMappings(
//                mapper -> mapper.map(src -> src.getCut(), DiscountsCustomerDTO::setCut)
//        );

        if(modelMapper.getTypeMap(Discounts.class,DiscountsCustomerDTO.class)==null){
            TypeMap<Discounts, DiscountsCustomerDTO> propertyMapper = modelMapper.createTypeMap(Discounts.class, DiscountsCustomerDTO.class);
            propertyMapper.addMappings(
                    mapper -> mapper.map(src -> src.getCut(), DiscountsCustomerDTO::setCut)

            );
        }

        List<DiscountsCustomerDTO> lsDisCustomer = modelMapper.map(lsDiscounts,new TypeToken<List<DiscountsCustomerDTO>>() {}.getType());



        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,lsDisCustomer,null,null);


    }
}
