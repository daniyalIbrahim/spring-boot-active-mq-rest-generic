package com.daniyal.generic.object.controller;

import com.daniyal.generic.object.model.Contract;
import com.daniyal.generic.object.service.ContractService;
import com.daniyal.generic.object.service.GenericService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/contract")
public class ContractContr extends GenericController<Contract> {

    @Autowired
    private static final Logger LOG = LoggerFactory.getLogger(ContractContr.class);

    @Autowired
    ContractService serv;

    @Override
    public GenericService<Contract> getService() {
        return serv;
    }
    /**
     *  GET
     */
    @GetMapping("/get/all")
    public ResponseEntity<?> listContracts(){
        try {
            Iterable<Contract> list =serv.findAll();
            return ResponseEntity.ok().body(list);
        } catch (Exception e) {
            LOG.error("Error sending object", e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while fetching data");
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> GetContract(@PathVariable("id") String id){
        try {
            Optional<Contract> x = serv.getoneobject(id);
            return ResponseEntity.ok().body(x);
        } catch (Exception e) {
            LOG.error("Error sending object", e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while fetching data");
    }
    /**
     *  PUT
     */
    @PutMapping("/update")
    public ResponseEntity<?> ContractUpdate(@RequestBody Contract c){
        try {

            serv.save(c);
            return ResponseEntity.ok().body("ok");
        } catch (Exception e) {
            LOG.error("Error sending object", e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while creating data");
    }
    /**
     *  POST
     */
    @PostMapping("/create")
    public ResponseEntity<?> ContractCreate(@RequestBody Contract c){
        try {
            serv.save(c);
            return ResponseEntity.ok().body("created Contract object");
        } catch (Exception e) {
            LOG.error("Error creating object", e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while creating data");
    }
    /**
     *  DELETE
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> ContractDelete(@PathVariable("id") String id){
        try {
            serv.delete(id);
            return ResponseEntity.ok().body("deleted");
        } catch (Exception e) {
            LOG.error("Error creating object", e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while creating data");
    }
}

