package com.nt.dao;

import java.util.List;

import com.nt.bo.EmpBo;

public interface EmpDao {

	public List<EmpBo> getEmpDetails(String desg1,String desg2,String desg3) throws Exception;
}
