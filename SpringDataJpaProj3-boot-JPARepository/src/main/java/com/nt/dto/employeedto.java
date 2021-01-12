package com.nt.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class employeedto {
	
	private Integer eno;
	private String ename;
	private String eadd;
	private Float esal;
	public employeedto(Integer eno)
	{
		this.eno=eno;
	}

}
