/*
@Author Bambang a.k.a. Bambang
calon menantu idaman
created with Eclipse intellij 2022.2.3
Created on 12/1/2022  2:41 PM
Last Modified on 12/1/20222:41 PM
Version 1.0
*/


package com.bcafinance.bpbspringboot.controllers;

import com.bcafinance.bpbspringboot.dto.DiscountsCustomerDTO;
import com.bcafinance.bpbspringboot.dto.GeographyDTO;
import com.bcafinance.bpbspringboot.dto.SellerDTO;
import com.bcafinance.bpbspringboot.handler.ResourceNotFoundException;
import com.bcafinance.bpbspringboot.handler.ResponseHandler;
import com.bcafinance.bpbspringboot.models.Geographies;
import com.bcafinance.bpbspringboot.models.Seller;
import com.bcafinance.bpbspringboot.services.SellerService;
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
public class SellerController {

    @Getter
    private SellerService selserv;

    private SellerController(){}

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    public SellerController(SellerService selserv) {
        this.selserv = selserv;
    }

    @PostMapping("/v1/seller")
    public ResponseEntity<Object>
    saveSeller(@Valid @RequestBody Seller seller) throws Exception {

        if(seller==null)throw new ResourceNotFoundException(ConstantMessage.ERROR_NO_CONTENT);
        selserv.saveSellers(seller);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED,null,null,null);
    }
    @PostMapping("/v1/seller/saveall")
    public ResponseEntity<Object>
    saveAllSeller(@Valid @RequestBody List<Seller> seller) throws Exception {


        if(seller==null)throw new ResourceNotFoundException(ConstantMessage.ERROR_NO_CONTENT);
        selserv.saveAllSeller(seller);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED,null,null,null);
    }


    @GetMapping("/v1/seller/{id}")
    public ResponseEntity<Object> getSellerById(@PathVariable("id") long id) throws Exception {
        Seller seller = selserv.findById(id);

        if(seller != null)
        {
            SellerDTO sellerDTO = modelMapper.map(seller,SellerDTO.class);

            return new ResponseHandler().
                    generateResponse(ConstantMessage.SUCCESS_FIND_BY, HttpStatus.OK,sellerDTO,null,null);
        }
        else
        {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_NOT_FOUND);
        }
    }
    @GetMapping("/v1/seller/email/{email}")
    public ResponseEntity<Object> getSellerbyEmail(@PathVariable("email") String email) throws Exception {
        Seller seller = selserv.findByEmailLike(email);

        if(seller != null)
        {
            SellerDTO sellerDTO = modelMapper.map(seller,SellerDTO.class);

            return new ResponseHandler().
                    generateResponse(ConstantMessage.SUCCESS_FIND_BY, HttpStatus.OK,sellerDTO,null,null);
        }
        else
        {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_NOT_FOUND);
        }
    }

    @GetMapping("/v1/seller/datas/all/0")
    public ResponseEntity<Object> findAllSellers()throws Exception{

        int data = 0;
        List<Seller> lsSeller = selserv.findAllSeller();

        if(lsSeller.size()==0)
        {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_DATA_EMPTY);
        }
        List<SellerDTO> lsSellerDTO = modelMapper.map(lsSeller,new TypeToken<List<SellerDTO>>() {}.getType());

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,lsSellerDTO,null,null);
    }





    @PutMapping("/v1/seller/upd")
    public ResponseEntity<Object> updateSellerById(@RequestBody Seller seller)throws Exception{
        selserv.updateSeller(seller);
        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,"",null,null);
    }


}
