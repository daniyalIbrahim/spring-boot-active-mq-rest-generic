package com.daniyal.generic.object.controller;


import com.daniyal.generic.object.model.Company;
import com.daniyal.generic.object.service.CompanyService;
import com.daniyal.generic.object.service.GenericService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyContr extends GenericController<Company> {


    private static final Logger LOG = LoggerFactory.getLogger(CompanyContr.class);

    @Autowired
    CompanyService serv;

    @Override
    public GenericService<Company> getService() {
        return serv;
    }

    /**
     *  GET
     */
    @GetMapping("/get/all")
    public ResponseEntity<?> listCompanies(){
        try {
            Iterable<Company> list =serv.findAll();
            return ResponseEntity.ok().body(list);
        } catch (Exception e) {
            LOG.error("Error sending object", e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while fetching data");
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> GetCompany(@PathVariable("id") String id){
        try {
            Optional<Company> x = serv.getoneobject(id);
            return ResponseEntity.ok().body(x);
        } catch (Exception e) {
            LOG.error("Error sending object", e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while fetching data");
    }
    /**
     *  PUT
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<?> companyUpdate(@PathVariable("id") String id,@RequestBody Company c){
        try {

             serv.updateCompany(c);
            return ResponseEntity.ok().body("ok");
        } catch (Exception e) {
            LOG.error("Error sending object", e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while creating data");
    }
    /**
     *  POST
     */
    @PostMapping("/create/")
    public ResponseEntity<?> companyCreate(@RequestBody Company c){
        try {
            Company company =(Company) serv.save(c);
            return ResponseEntity.ok().body(company);
        } catch (Exception e) {
            LOG.error("Error creating object", e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while creating data");
    }
    /**
     *  DELETE
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> companyDelete(@PathVariable("id") String id){
        try {
            serv.delete(id);

            return ResponseEntity.ok().body("deleted");
        } catch (Exception e) {
            LOG.error("Error creating object", e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while creating data");
    }
}

