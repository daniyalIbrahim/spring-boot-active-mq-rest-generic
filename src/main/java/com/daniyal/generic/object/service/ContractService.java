package com.daniyal.generic.object.service;


import com.daniyal.generic.object.model.Contract;
import com.daniyal.generic.object.repository.ContractRepo;
import com.daniyal.generic.object.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractService extends GenericService<Contract> {

    @Autowired
    ContractRepo repo;

    @Override
    public GenericRepository<Contract> getRepository() {
        return repo;
    }
}
