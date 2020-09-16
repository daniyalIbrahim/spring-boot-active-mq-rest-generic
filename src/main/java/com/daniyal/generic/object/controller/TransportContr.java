package com.daniyal.generic.object.controller;


import com.daniyal.generic.object.model.Transport;
import com.daniyal.generic.object.service.GenericService;
import com.daniyal.generic.object.service.TransportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/transport")
public class TransportContr extends GenericController<Transport> {

    @Autowired
    private static final Logger LOG = LoggerFactory.getLogger(TransportContr.class);

    @Autowired
    TransportService serv;

    @Override
    public GenericService<Transport> getService() {
        return serv;
    }
    /**
     *  GET
     */
    @GetMapping("/get/all")
    public ResponseEntity<?> listTransports(){
        try {
            Iterable<Transport> list =serv.findAll();
            return ResponseEntity.ok().body(list);
        } catch (Exception e) {
            LOG.error("Error sending object", e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while fetching data");
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> GetTransport(@PathVariable("id") String id){
        try {
            Optional<Transport> x = serv.getoneobject(id);
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
    public ResponseEntity<?> TransportUpdate(@RequestBody Transport c){
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
    public ResponseEntity<?> TransportCreate(@RequestBody Transport c){
        try {
            serv.save(c);
            return ResponseEntity.ok().body("created Transport object");
        } catch (Exception e) {
            LOG.error("Error creating object", e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while creating data");
    }
    /**
     *  DELETE
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> TransportDelete(@PathVariable("id") String id){
        try {
            serv.delete(id);
            return ResponseEntity.ok().body("deleted");
        } catch (Exception e) {
            LOG.error("Error creating object", e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while creating data");
    }
}

