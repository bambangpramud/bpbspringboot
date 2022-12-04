/*
@Author Bambang a.k.a. Bambang
calon menantu idaman
created with Eclipse intellij 2022.2.3
Created on 12/1/2022  2:43 PM
Last Modified on 12/1/20222:43 PM
Version 1.0
*/


package com.bcafinance.bpbspringboot.services;


import com.bcafinance.bpbspringboot.handler.FormatValidation;
import com.bcafinance.bpbspringboot.handler.ResourceNotFoundException;
import com.bcafinance.bpbspringboot.models.Seller;
import com.bcafinance.bpbspringboot.repos.SellerRepo;
import com.bcafinance.bpbspringboot.utils.ConstantMessage;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class SellerService {

    private SellerRepo selrepo;

    public SellerService(SellerRepo selrepo) {
        this.selrepo = selrepo;
    }

    public List<Seller> findAllSeller(){
        return selrepo.findAll();

    }


    public Seller findById(Long id) throws Exception{
        return selrepo.findById(id).
                orElseThrow(() -> new ResourceNotFoundException(ConstantMessage.WARNING_NOT_FOUND));
    }

    public Seller findByEmailLike(String email) throws Exception{
        return selrepo.findByEmailLike(email).
                orElseThrow(() -> new ResourceNotFoundException(ConstantMessage.WARNING_NOT_FOUND));
    }

    public void saveSellers(Seller seller) throws Exception
    {
        if(seller.getEmail()==null)throw new DataIntegrityViolationException(ConstantMessage.ERROR_DATA_INVALID);
        if(seller.getBirthDate()==null)throw new DataIntegrityViolationException(ConstantMessage.ERROR_DATA_INVALID);
        if(seller.getName()==null)throw new DataIntegrityViolationException(ConstantMessage.ERROR_DATA_INVALID);
        if(seller.getPhoneNumber()==null)throw new DataIntegrityViolationException(ConstantMessage.ERROR_DATA_INVALID);
        if(seller.getGeographies()==null)throw new DataIntegrityViolationException(ConstantMessage.ERROR_DATA_INVALID);
        if(seller.getPartners()==null)throw new DataIntegrityViolationException(ConstantMessage.ERROR_DATA_INVALID);


        FormatValidation.phoneNumberFormatValidation(seller.getPhoneNumber());
        FormatValidation.emailFormatValidation(seller.getEmail());
        FormatValidation.dateFormatYYYYMMDDValidation(seller.getBirthDate().toString());

        Optional<Seller> selByEmail = selrepo.findByEmail(seller.getEmail());
        if(selByEmail.isPresent())
        {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_EMAIL_EXIST);
        }
        selrepo.save(seller);
    }


    @Transactional
    public void updateSeller(Seller c) throws Exception{

        Seller seller = selrepo.findById(c.getId()).orElseThrow(()->
                new ResourceNotFoundException(ConstantMessage.WARNING_CUSTOMER_NOT_FOUND));

        seller.setModifiedBy("1");
        seller.setModifiedDate(new Date());
        if(c.getName() != null
                && !Objects.equals(seller.getName(),c.getName())
                && !c.getName().equals(""))
        {
            seller.setName(c.getName());//BERARTI ADA PERUBAHAN DI SINI
        }

        if(c.getEmail() != null &&
                c.getEmail().length()>0 &&
                !Objects.equals(seller.getEmail(),c.getEmail()))

        {
            FormatValidation.emailFormatValidation(c.getEmail());

            Optional<Seller> cBeanOptional = selrepo.findByEmail(c.getEmail());
            if(cBeanOptional.isPresent())//it means if exists
            {
                throw new ResourceNotFoundException(ConstantMessage.WARNING_EMAIL_EXIST);
            }
            seller.setEmail(c.getEmail());
        }

        if(c.getGeographies() != null
                && !Objects.equals(seller.getGeographies(),c.getGeographies())
               )
        {
            seller.setGeographies(c.getGeographies());//BERARTI ADA PERUBAHAN DI SINI
        }
        if(c.getPartners() != null
                && !Objects.equals(seller.getPartners(),c.getPartners())
        )
        {
            seller.setPartners(c.getPartners());//BERARTI ADA PERUBAHAN DI SINI
        }

        if(c.getPhoneNumber() != null &&
                c.getPhoneNumber().length()>0 &&
                !Objects.equals(seller.getPhoneNumber(),c.getPhoneNumber())){

            FormatValidation.phoneNumberFormatValidation(c.getPhoneNumber());
            seller.setPhoneNumber(c.getPhoneNumber());
        }
        if(c.getBirthDate() != null &&
                !c.getBirthDate().toString().equals("") &&
                !Objects.equals(seller.getBirthDate().toString(),c.getBirthDate().toString()))
        {
            FormatValidation.dateFormatYYYYMMDDValidation(seller.getBirthDate().toString());
            seller.setBirthDate(c.getBirthDate());
        }
    }

    @Transactional(rollbackFor = {Exception.class})
    public void saveAllSeller(List<Seller> sellers){
        selrepo.saveAll(sellers);
    }


}
