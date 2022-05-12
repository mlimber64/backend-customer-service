package com.nttdata.bootcamp.backend.customer.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nttdata.bootcamp.backend.customer.model.customer;
import com.nttdata.bootcamp.backend.customer.repository.customerRepository;
import com.nttdata.bootcamp.backend.customer.service.customerService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class customerServiceImpl implements customerService{
	
	@Autowired
	private customerRepository repositoryCustomer;
	

	@Override
	public Flux<customer> findAll() {
		return repositoryCustomer.findAll();
	}

	@Override
	public Mono<customer> findAllById(String id) {
		return repositoryCustomer.findById(id);
	}

	@Override
	public Mono<customer> save(customer c) {
		return repositoryCustomer.save(c);
	}

	@Override
	public Mono<customer> update(String id, customer c) {
		return repositoryCustomer.findById(id)
				.flatMap(cu -> {
					cu.setId(id);
					return save(c);
				})
				.switchIfEmpty(Mono.empty());
	}

	@Override
	public Mono<customer> delete(String id) {
		return repositoryCustomer
				.findById(id)
				.flatMap(c -> repositoryCustomer.deleteById(c.getId()).thenReturn(c));
	}

}
