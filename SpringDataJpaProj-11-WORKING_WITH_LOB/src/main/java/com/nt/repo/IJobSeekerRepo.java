package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.JobSeeker;

public interface IJobSeekerRepo extends JpaRepository<JobSeeker,Integer> {

}
