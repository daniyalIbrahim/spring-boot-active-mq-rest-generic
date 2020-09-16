package com.daniyal.generic.object.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface GenericRepository<T> extends CrudRepository<T,String>, MongoRepository<T,String> {


}




