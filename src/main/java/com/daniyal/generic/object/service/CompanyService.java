package com.daniyal.generic.object.service;

import com.daniyal.generic.object.model.Company;
import com.daniyal.generic.object.repository.CompanyRepo;
import com.daniyal.generic.object.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService extends GenericService<Company> {

    @Autowired
    CompanyRepo repo;

    @Override
    public GenericRepository<Company> getRepository() {
        return repo;
    }


    @Override
    public Iterable<Company> findAll() {
        return repo.findAll();
    }

    @Override
    public Company save(Company entity) {
        return repo.save(entity);
    }

    @Override
    public void delete(String id) {
        repo.deleteById(id);
    }


    public void updateCompany(Company company) {
        repo.save(company);
    }

}


