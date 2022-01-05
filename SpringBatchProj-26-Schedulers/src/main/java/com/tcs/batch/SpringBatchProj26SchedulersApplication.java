package com.tcs.batch;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableBatchProcessing
@EnableScheduling
public class SpringBatchProj26SchedulersApplication {

	@Autowired
	JobBuilderFactory jbf;
	
	@Autowired
	StepBuilderFactory sbf;
	
	@Autowired
	JobLauncher jl;
	
	@Scheduled(cron = "0/30 * * * * *")
	public void runthejob() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException
	{
	  JobParametersBuilder jpb=new JobParametersBuilder();
	  jpb.addDate("Current Date:",new Date());
	  jpb.addString("key", "value");
	  jl.run(schedulerjobexampleJob(),jpb.toJobParameters());
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBatchProj26SchedulersApplication.class, args);
	}
	
	@Bean
	public Job schedulerjobexampleJob()
	{
		return jbf.get("schedulerjob").start(stepmethod()).build();
	}
	
	@Bean
	public Step stepmethod()
	{
		return sbf.get("schedulingstep").tasklet(new Tasklet() {
			
			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				System.out.println("The present time::"+LocalDateTime.now());
				return RepeatStatus.FINISHED;
			}
		}).build();
	}

}
