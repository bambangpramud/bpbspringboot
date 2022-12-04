/*
@Author Bambang a.k.a. Bambang
calon menantu idaman
created with Eclipse intellij 2022.2.3
Created on 12/2/2022  9:39 AM
Last Modified on 12/2/20229:39 AM
Version 1.0
*/


package com.bcafinance.bpbspringboot.services;

import com.bcafinance.bpbspringboot.handler.FormatValidation;
import com.bcafinance.bpbspringboot.handler.ResourceNotFoundException;
import com.bcafinance.bpbspringboot.models.Discounts;
import com.bcafinance.bpbspringboot.models.Geographies;
import com.bcafinance.bpbspringboot.models.Seller;
import com.bcafinance.bpbspringboot.repos.DiscountsRepo;
import com.bcafinance.bpbspringboot.utils.ConstantMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DiscountService {

    private DiscountsRepo disrepo;

    @Autowired
    public DiscountService(DiscountsRepo disrepo) {
        this.disrepo = disrepo;
    }

    public List<Discounts> findAllDiscounts(){
        return disrepo.findAll();

    }

    public Discounts findById(Long id) throws Exception{
        return disrepo.findById(id).
                orElseThrow(() -> new ResourceNotFoundException(ConstantMessage.WARNING_NOT_FOUND));
    }

    public void saveDiscounts(Discounts discount) throws Exception
    {
        if(discount.getName()==null)throw new DataIntegrityViolationException(ConstantMessage.ERROR_DATA_INVALID);
        if(discount.getDescription()==null)throw new DataIntegrityViolationException(ConstantMessage.ERROR_DATA_INVALID);
        if(discount.getCut()==null)throw new DataIntegrityViolationException(ConstantMessage.ERROR_DATA_INVALID);
        if(discount.getStartDate()==null)throw new DataIntegrityViolationException(ConstantMessage.ERROR_DATA_INVALID);
        if(discount.getEndDate()==null)throw new DataIntegrityViolationException(ConstantMessage.ERROR_DATA_INVALID);
        if(discount.getLimit()==null)throw new DataIntegrityViolationException(ConstantMessage.ERROR_DATA_INVALID);



        FormatValidation.dateFormatYYYYMMDDValidation(discount.getStartDate().toString());
        FormatValidation.dateFormatYYYYMMDDValidation(discount.getEndDate().toString());

        Optional<Discounts> disByName = disrepo.findByName(discount.getName());
        if(disByName.isPresent())
        {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_DISCOUNT_EXIST);
        }
        disrepo.save(discount);
    }



}
