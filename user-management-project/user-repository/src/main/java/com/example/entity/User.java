package com.example.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name ="USER")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter @Setter private Long id;
	
	@CreationTimestamp
	@Getter @Setter private Date createdDate;
	
	@Column(nullable = false)
	@Getter @Setter private Boolean oldUser = false;
	
	@Getter @Setter private String name;
	
	@Getter @Setter private String surname;
	
	@Getter @Setter private Integer age;
	
	/*
	@OneToMany
	private Set<Address> addresses;
	*/
}
