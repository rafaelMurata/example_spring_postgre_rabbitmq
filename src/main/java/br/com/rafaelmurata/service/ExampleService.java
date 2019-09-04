package br.com.rafaelmurata.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.rafaelmurata.model.Employee;
import br.com.rafaelmurata.repository.ExampleRepository;

@Service
public class ExampleService {

	@Autowired
	private ExampleRepository repository;
	
	@Transactional
	@PostConstruct
	public void init() {
		Employee employee = new Employee("Rafael Murata",1,20.00);
		
		repository.save(employee);
	}
	
	public List<Employee> findAll() {
		return repository.findAll();
	}
}
