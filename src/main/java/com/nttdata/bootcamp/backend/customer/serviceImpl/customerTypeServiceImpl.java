package com.nttdata.bootcamp.backend.customer.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nttdata.bootcamp.backend.customer.model.customerType;
import com.nttdata.bootcamp.backend.customer.repository.customerTypeRepository;
import com.nttdata.bootcamp.backend.customer.service.customerTypeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class customerTypeServiceImpl implements customerTypeService{
	
	@Autowired
	private customerTypeRepository repositoryType;

	@Override
	public Flux<customerType> findAll() {
		return repositoryType.findAll();
	}

	@Override
	public Mono<customerType> findAllById(String id) {
		return repositoryType.findById(id);
	}

	@Override
	public Mono<customerType> save(customerType c) {
		return repositoryType.save(c);
	}

	@Override
	public Mono<customerType> update(String id, customerType c) {
		return repositoryType.findById(id)
				.flatMap(cu -> {
					cu.setId(id);
					return save(c);
				})
				.switchIfEmpty(Mono.empty());
	}

	@Override
	public Mono<customerType> delete(String id) {
		return repositoryType
				.findById(id)
				.flatMap(c -> repositoryType.deleteById(c.getId()).thenReturn(c));
	}
	
	
	
}
