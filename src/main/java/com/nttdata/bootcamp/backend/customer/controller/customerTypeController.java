package com.nttdata.bootcamp.backend.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nttdata.bootcamp.backend.customer.model.customerType;
import com.nttdata.bootcamp.backend.customer.service.customerTypeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/customerType")
public class customerTypeController {
	
	@Autowired
	private customerTypeService serviceType;
	
	@GetMapping
	private Flux<customerType> findAll(){
		return serviceType.findAll();
	}
	
	@GetMapping("/type/{id}")
	private Mono<customerType> findById(String id){
		return serviceType.findAllById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	private Mono<customerType> save(@RequestBody customerType c){
		return serviceType.save(c);
	}
	
	@PutMapping("/type/{id}")
	private Mono<ResponseEntity<customerType>> update(@PathVariable("id")String id,@RequestBody customerType c){
		return serviceType.update(id, c)
				.flatMap(cu -> Mono.just(ResponseEntity.ok(cu)))
				.switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
	}
	
	@DeleteMapping("/type/{id}")
	private Mono<ResponseEntity<customerType>> delete(@PathVariable("id") String id){
		return serviceType.delete(id)
				.flatMap(c -> Mono.just(ResponseEntity.ok(c)))
				.switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
	}

}
