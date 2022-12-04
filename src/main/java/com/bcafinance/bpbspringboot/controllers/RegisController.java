/*
@Author Bambang a.k.a. Bambang
calon menantu idaman
created with Eclipse intellij 2022.2.3
Created on 12/4/2022  8:44 PM
Last Modified on 12/4/20228:44 PM
Version 1.0
*/


package com.bcafinance.bpbspringboot.controllers;


import com.bcafinance.bpbspringboot.configuration.ConfigProperties;
import com.bcafinance.bpbspringboot.core.SMTPCore;
import com.bcafinance.bpbspringboot.handler.ResourceNotFoundException;
import com.bcafinance.bpbspringboot.handler.ResponseHandler;
import com.bcafinance.bpbspringboot.models.Registrasi;
import com.bcafinance.bpbspringboot.services.RegistrasiService;
import com.bcafinance.bpbspringboot.utils.ConstantMessage;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class RegisController {

    @Getter
    private RegistrasiService registrasiService;

    public RegisController(){
    }

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public RegisController(RegistrasiService registrasiService){
        this.registrasiService = registrasiService;
    }

    @PostMapping("/v1/registrasi")
    public ResponseEntity<Object>
    saveEmails( @RequestBody Registrasi regis) throws Exception {
        if(regis==null)throw new ResourceNotFoundException(ConstantMessage.ERROR_NO_CONTENT);
        String[] strArr = new String[regis.size()];
        strArr[0] = regis.getEmails();
        Date uhuy = new Date();
        String token = regis.getEmails().substring(0,5)+uhuy.getTime()+"uhuy";
        regis.setToken(token);

        registrasiService.saveEmail(regis);

        System.out.println(System.getProperty("user.dir"));
        SMTPCore sc = new SMTPCore();
        ConfigProperties.getEmailPassword();
        String s = "coba";
        System.out.println(sc.sendMailWithAttachment(strArr,
                "EMAIL AUTHENTICATION","TOKEN REGISTRATION : "+"http://localhost:8080/api/v1/a/"+token,
                "SSL",
                new String[] {ResourceUtils.getFile("classpath:\\data\\sample.docx").getAbsolutePath()}));


        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SEND_EMAIL, HttpStatus.CREATED,null,null,null);
    }
    @GetMapping("/v1/a/{token}")
    public ResponseEntity<Object>
    verifRegistrasi(@PathVariable("token") String token)throws Exception{
        Optional<Registrasi> regis = registrasiService.getRegisbyToken(token);

        if (!regis.isPresent()){
            throw new ResourceNotFoundException(ConstantMessage.WARNING_NOT_FOUND);
        }
        return new ResponseHandler().generateResponse(ConstantMessage.EMAIL_VERIF_SUCCES, HttpStatus.CREATED,null,null,null);


    }

}
