package com.nt.controller;
import com.nt.dto.CricketerAvgDto;
import com.nt.service.*;
import com.nt.vo.CricketerAvgVo;
public class CricketerAvgController {
private CricketerAvgServiceImpl service;
CricketerAvgDto dto=new CricketerAvgDto();

public CricketerAvgController(CricketerAvgServiceImpl service) {
	
	this.service=service;
}
public String process(CricketerAvgVo vo) throws Exception
{
	dto.setName(vo.getName());
	dto.setRunsscored(Integer.parseInt(vo.getRunsscored()));
	dto.setGotout(Integer.parseInt(vo.getGotout()));
	dto.setRunsgiven(Integer.parseInt(vo.getRunsgiven()));
	dto.setWicketstaken(Integer.parseInt(vo.getWicketstaken()));
	String res=service.calculateAvg(dto);
	return res;
}

}
