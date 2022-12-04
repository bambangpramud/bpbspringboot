/*
@Author Bambang a.k.a. Bambang
calon menantu idaman
created with Eclipse intellij 2022.2.3
Created on 12/2/2022  2:08 PM
Last Modified on 12/2/20222:08 PM
Version 1.0
*/


package com.bcafinance.bpbspringboot.controllers;

import com.bcafinance.bpbspringboot.dto.PartnersDTO;
import com.bcafinance.bpbspringboot.handler.ResourceNotFoundException;
import com.bcafinance.bpbspringboot.handler.ResponseHandler;
import com.bcafinance.bpbspringboot.models.Partners;
import com.bcafinance.bpbspringboot.services.PartnersService;
import com.bcafinance.bpbspringboot.utils.ConstantMessage;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/")
public class PartnersController {

    @Getter
    private PartnersService partnersService;

    public PartnersController(){}

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public PartnersController(PartnersService partnersService) {
        this.partnersService = partnersService;
    }


    @PostMapping("/v1/partners")
    public ResponseEntity<Object>
    savePartners(@Valid @RequestBody Partners partners) throws Exception {


        if(partners==null)throw new ResourceNotFoundException(ConstantMessage.ERROR_NO_CONTENT);
        partnersService.savePartner(partners);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED,null,null,null);
    }

    @PostMapping("/v1/partners/saveall")
    public ResponseEntity<Object>
    saveAllPartners(@Valid @RequestBody List<Partners> partners) throws Exception {


        if(partners==null)throw new ResourceNotFoundException(ConstantMessage.ERROR_NO_CONTENT);
        partnersService.saveAllPartners(partners);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED,null,null,null);
    }


    @GetMapping("/v1/partners/datas/dto/0")
    public ResponseEntity<Object> findAllDiscountsCustomer()throws Exception{

        int data = 0;
        List<Partners> lsPartners = partnersService.findAllPartners();

        if(lsPartners.size()==0)
        {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_DATA_EMPTY);
        }

        List<PartnersDTO> lsPartnersDTO = modelMapper.map(lsPartners, new TypeToken<List<PartnersDTO>>() {}.getType());

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,lsPartnersDTO,null,null);
    }

    @GetMapping("/v1/partner/{id}")
    public ResponseEntity<Object> getSellerById(@PathVariable("id") long id) throws Exception {
        Partners partners = partnersService.findById(id);

        if(partners != null)
        {
            PartnersDTO partnersDTO = modelMapper.map(partners,PartnersDTO.class);

            return new ResponseHandler().
                    generateResponse(ConstantMessage.SUCCESS_FIND_BY, HttpStatus.OK,partnersDTO,null,null);
        }
        else
        {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_NOT_FOUND);
        }
    }
    @GetMapping("/v1/partner/email/{email}")
    public ResponseEntity<Object> getPartnerByEmail(@PathVariable("email") String email) throws Exception {
        Partners partners = partnersService.findByEmailLike(email);

        if(partners != null)
        {
            PartnersDTO partnersDTO = modelMapper.map(partners,PartnersDTO.class);

            return new ResponseHandler().
                    generateResponse(ConstantMessage.SUCCESS_FIND_BY, HttpStatus.OK,partnersDTO,null,null);
        }
        else
        {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_NOT_FOUND);
        }
    }

    @PutMapping("/v1/partner/upd")
    public ResponseEntity<Object> updateSellerById(@RequestBody Partners partners)throws Exception{
        partnersService.updatePartners(partners);
        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,"",null,null);
    }

}

