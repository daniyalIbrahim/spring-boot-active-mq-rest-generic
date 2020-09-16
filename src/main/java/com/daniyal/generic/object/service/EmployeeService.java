package com.daniyal.generic.object.service;


import com.daniyal.generic.object.model.Employee;
import com.daniyal.generic.object.repository.EmployeeRepo;
import com.daniyal.generic.object.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService extends GenericService<Employee> {

     @Autowired
     EmployeeRepo repo;

    @Override
    public GenericRepository<Employee> getRepository() {
        return repo;
    }
}



