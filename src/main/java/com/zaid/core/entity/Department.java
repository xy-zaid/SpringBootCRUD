package com.zaid.core.entity;

import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;


@Entity
@Data//lombok 
public class Department {
	
	@Id
	@GeneratedValue(generator = "auto")
	private long departmentId;
	@NotNull(message = "dept name is given")//validation
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;
	
}
