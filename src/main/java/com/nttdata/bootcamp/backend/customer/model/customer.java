package com.nttdata.bootcamp.backend.customer.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@Document(collection = "customers")
public class customer {
	
	@Id
	private String id;
	@Field
	private int idType;
	@Field
	private String firstName;
	@Field
	private String lastName;
	@Field
	private int age;
	@Field
	private int numberPhone;
	@Field
	private String email;
	@Field
	private Boolean active;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getIdType() {
		return idType;
	}
	public void setIdType(int idType) {
		this.idType = idType;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getNumberPhone() {
		return numberPhone;
	}
	public void setNumberPhone(int numberPhone) {
		this.numberPhone = numberPhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	
}
