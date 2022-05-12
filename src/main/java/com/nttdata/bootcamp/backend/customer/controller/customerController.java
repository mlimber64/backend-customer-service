package com.nttdata.bootcamp.backend.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nttdata.bootcamp.backend.customer.model.customer;
import com.nttdata.bootcamp.backend.customer.service.customerService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/customer")
public class customerController {
	
	@Autowired
	private customerService serviceCustomer;
	
	@GetMapping
	private Flux<customer> findAll(){
		return serviceCustomer.findAll();
	}
	
	@GetMapping("/customer/{id}")
	private Mono<customer> findById(String id){
		return serviceCustomer.findAllById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	private Mono<customer> save(@RequestBody customer c){
		return serviceCustomer.save(c);
	}
	
	@PutMapping("/customer/{id}")
	private Mono<ResponseEntity<customer>> update(@PathVariable("id")String id,@RequestBody customer ca){
		return serviceCustomer.update(id, ca)
				.flatMap(cu -> Mono.just(ResponseEntity.ok(cu)))
				.switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
	}
	
	@DeleteMapping("/cusotmer/{id}")
	private Mono<ResponseEntity<customer>> delete(@PathVariable("id") String id){
		return serviceCustomer.delete(id)
				.flatMap(c -> Mono.just(ResponseEntity.ok(c)))
				.switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
	}

}
