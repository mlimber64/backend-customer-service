package com.nttdata.bootcamp.backend.customer.service;

import org.springframework.stereotype.Service;

import com.nttdata.bootcamp.backend.customer.model.customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface customerService {
	
	Flux<customer> findAll();
	
	Mono<customer> findAllById(String id);
	
	Mono<customer> save(customer c);
	
	Mono<customer> update(String id, customer c);
	
	Mono<customer> delete(String id);

}
