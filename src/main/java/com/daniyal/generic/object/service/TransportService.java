package com.daniyal.generic.object.service;


import com.daniyal.generic.object.model.Transport;
import com.daniyal.generic.object.repository.GenericRepository;
import com.daniyal.generic.object.repository.TransportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransportService extends GenericService<Transport> {

    @Autowired
    TransportRepo repo;

    @Override
    public GenericRepository<Transport> getRepository() {
        return repo;
    }
}
