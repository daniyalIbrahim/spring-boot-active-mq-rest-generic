package com.daniyal.generic.object.controller;


import com.daniyal.generic.object.model.Device;
import com.daniyal.generic.object.service.DeviceService;
import com.daniyal.generic.object.service.GenericService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/device")
public class DeviceContr extends GenericController<Device> {

    @Autowired
    private static final Logger LOG = LoggerFactory.getLogger(DeviceContr.class);

    @Autowired
    DeviceService serv;

    @Override
    public GenericService<Device> getService() {
        return serv;
    }
    /**
     *  GET
     */
    @GetMapping("/get/all")
    public ResponseEntity<?> listDevices(){
        try {
            Iterable<Device> list =serv.findAll();
            return ResponseEntity.ok().body(list);
        } catch (Exception e) {
            LOG.error("Error sending object", e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while fetching data");
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> GetDevice(@PathVariable("id") String id){
        try {
            Optional<Device> x = serv.getoneobject(id);
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
    public ResponseEntity<?> DeviceUpdate(@RequestBody Device c){
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
    public ResponseEntity<?> DeviceCreate(@RequestBody Device c){
        try {
            serv.save(c);
            return ResponseEntity.ok().body("created Device object");
        } catch (Exception e) {
            LOG.error("Error creating object", e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while creating data");
    }
    /**
     *  DELETE
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> DeviceDelete(@PathVariable("id") String id){
        try {
            serv.delete(id);
            return ResponseEntity.ok().body("deleted");
        } catch (Exception e) {
            LOG.error("Error creating object", e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while creating data");
    }
}

