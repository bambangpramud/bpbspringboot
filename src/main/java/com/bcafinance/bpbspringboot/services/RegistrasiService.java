/*
@Author Bambang a.k.a. Bambang
calon menantu idaman
created with Eclipse intellij 2022.2.3
Created on 12/4/2022  8:08 PM
Last Modified on 12/4/20228:08 PM
Version 1.0
*/


package com.bcafinance.bpbspringboot.services;


import com.bcafinance.bpbspringboot.handler.ResourceNotFoundException;
import com.bcafinance.bpbspringboot.models.Registrasi;
import com.bcafinance.bpbspringboot.repos.RegistrasiRepo;
import com.bcafinance.bpbspringboot.utils.ConstantMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RegistrasiService {

    @Autowired
    private RegistrasiRepo regirepo;


//    @Autowired
//    EmailService(EmailRepo emailRepo){this.emailRepo = emailRepo;}

//    @Autowired
//    EmailService(TokenRepo tokenRepo) { this.tokenRepo = tokenRepo; }

    public void saveEmail(Registrasi regis) throws Exception{
        if(regis.getEmails()==null)throw new DataIntegrityViolationException(ConstantMessage.ERROR_DATA_INVALID);

        Optional<Registrasi> getEmail = regirepo.findByEmails(regis.getEmails());
        if(getEmail.isPresent())
        {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_EMAIL_EXISTING);
        }

        regirepo.save(regis
        );
    }

    public Optional<Registrasi> getRegisbyToken(String token){
        return regirepo.findByToken(token);
    }
}
