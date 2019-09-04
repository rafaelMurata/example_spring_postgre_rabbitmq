package br.com.rafaelmurata.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rafaelmurata.model.Employee;

public interface ExampleRepository extends JpaRepository<Employee, Long> {

}
