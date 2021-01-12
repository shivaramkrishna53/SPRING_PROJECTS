package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dto.JobSeekerDto;
import com.nt.entity.JobSeeker;
import com.nt.repo.IJobSeekerRepo;
@Service("jobser")
public class JobSeekerImpl implements IjobSer {

	@Autowired
	IJobSeekerRepo repo;
	
	@Override
	public String registerJobSekker(JobSeekerDto dto) {
		JobSeeker entity=new JobSeeker();
		BeanUtils.copyProperties(dto,entity);
		int id=repo.save(entity).getJsid();
		return "jobseeker successfully registered with the id:"+id;
	}

}
