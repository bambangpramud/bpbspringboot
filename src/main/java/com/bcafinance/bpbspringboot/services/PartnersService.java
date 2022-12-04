/*
@Author Bambang a.k.a. Bambang
calon menantu idaman
created with Eclipse intellij 2022.2.3
Created on 12/2/2022  2:07 PM
Last Modified on 12/2/20222:07 PM
Version 1.0
*/


package com.bcafinance.bpbspringboot.services;

import com.bcafinance.bpbspringboot.handler.FormatValidation;
import com.bcafinance.bpbspringboot.handler.ResourceNotFoundException;
import com.bcafinance.bpbspringboot.models.Partners;
import com.bcafinance.bpbspringboot.repos.PartnersRepo;
import com.bcafinance.bpbspringboot.utils.ConstantMessage;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PartnersService {

    private PartnersRepo partnersRepo;

    public PartnersService(PartnersRepo partnersRepo) {
        this.partnersRepo = partnersRepo;
    }

    public List<Partners> findAllPartners(){
        return partnersRepo.findAll();

    }

    public Partners findById(Long id) throws Exception{
        return partnersRepo.findById(id).
                orElseThrow(() -> new ResourceNotFoundException(ConstantMessage.WARNING_NOT_FOUND));
    }
    public Partners findByEmailLike(String email) throws Exception{
        return partnersRepo.findByEmailLikeIgnoreCase(email).
                orElseThrow(() -> new ResourceNotFoundException(ConstantMessage.WARNING_NOT_FOUND));
    }

    public void savePartner(Partners partners) throws Exception
    {
        if(partners.getEmail()==null)throw new DataIntegrityViolationException(ConstantMessage.ERROR_DATA_INVALID);
        if(partners.getName()==null)throw new DataIntegrityViolationException(ConstantMessage.ERROR_DATA_INVALID);
        if(partners.getPhoneNumber()==null)throw new DataIntegrityViolationException(ConstantMessage.ERROR_DATA_INVALID);

        FormatValidation.phoneNumberFormatValidation(partners.getPhoneNumber());
        FormatValidation.emailFormatValidation(partners.getEmail());

        Optional<Partners> parByEmail = partnersRepo.findByEmail(partners.getEmail());
        if(parByEmail.isPresent())
        {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_EMAIL_EXIST);
        }
        partnersRepo.save(partners);
    }

    @Transactional(rollbackFor = {Exception.class})
    public  void updatePartners(Partners c) throws Exception{

        Partners partners = partnersRepo.findById(c.getId()).orElseThrow(()->
                new ResourceNotFoundException(ConstantMessage.WARNING_GEOGRAPHY_NOT_FOUND));

        partners.setModifiedBy("1");
        partners.setModifiedDate(new Date());
        if (c.getName() !=null && !c.getName().equals(""))
        {

            partners.setName(c.getName());
        }
        if (c.getPhoneNumber() !=null && !c.getPhoneNumber().equals(""))
        {

            FormatValidation.phoneNumberFormatValidation(c.getPhoneNumber());
            partners.setPhoneNumber(c.getPhoneNumber());
        }
        if (c.getEmail() !=null && !c.getEmail().equals(""))
        {
            FormatValidation.emailFormatValidation(partners.getEmail());
            partners.setEmail(c.getEmail());
        }
        if (c.getSeller() !=null && !c.getSeller().equals(""))
        {

            partners.setSeller(c.getSeller());
        }
    }

    @Transactional(rollbackFor = {Exception.class})
    public void saveAllPartners(List<Partners> partners){
        partnersRepo.saveAll(partners);
    }
}
