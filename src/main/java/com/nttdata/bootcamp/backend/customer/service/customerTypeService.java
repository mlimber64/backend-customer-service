package com.nttdata.bootcamp.backend.customer.service;

import org.springframework.stereotype.Service;

import com.nttdata.bootcamp.backend.customer.model.customerType;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface customerTypeService {
	
	Flux<customerType> findAll();
	
	Mono<customerType> findAllById(String id);
	
	Mono<customerType> save(customerType c);
	
	Mono<customerType> update(String id, customerType c);
	
	Mono<customerType> delete(String id);

}
