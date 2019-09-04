package br.com.rafaelmurata.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Employee(String name, long id, double salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
	}
	
	public Employee() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	public long id;
	
	@Column(name="name")
	public String name;
	
	@Column(name="salary")
	private double salary;



	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

	public Double getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", salary=" + salary + "]";
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
