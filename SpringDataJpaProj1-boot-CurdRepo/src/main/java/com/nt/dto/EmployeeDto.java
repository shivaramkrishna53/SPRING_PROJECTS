package com.nt.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto  implements Serializable {
	private Integer eno;
	private String ename;
	private String eadd;
	private Float esal;
	public EmployeeDto(Integer eno)
	{
		this.eno=eno;
	}

}
