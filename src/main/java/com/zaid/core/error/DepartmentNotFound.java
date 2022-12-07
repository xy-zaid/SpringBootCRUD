package com.zaid.core.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentNotFound extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;

}
