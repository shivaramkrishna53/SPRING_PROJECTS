package com.nt.service;

import java.util.List;

import com.nt.dto.EmpDto;

public interface EmpService {
	public List<EmpDto> SendEmpDetails(String desg1,String desg2,String desg3) throws Exception;

}
