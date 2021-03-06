package com.nttdata.bootcamp.backend.customer.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.bootcamp.backend.customer.model.customer;

@Repository
public interface customerRepository extends ReactiveMongoRepository<customer, String>{

}
