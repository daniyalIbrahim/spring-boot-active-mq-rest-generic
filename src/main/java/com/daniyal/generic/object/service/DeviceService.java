package com.daniyal.generic.object.service;


import com.daniyal.generic.object.model.Device;
import com.daniyal.generic.object.repository.DeviceRepo;
import com.daniyal.generic.object.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceService extends GenericService<Device> {

    @Autowired
    DeviceRepo repo;

    @Override
    public GenericRepository<Device> getRepository(){
        return repo;
    }
}
