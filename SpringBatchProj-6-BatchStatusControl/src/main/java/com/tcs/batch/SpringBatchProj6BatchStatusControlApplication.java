package com.tcs.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableBatchProcessing
public class SpringBatchProj6BatchStatusControlApplication {

	@Autowired
	JobBuilderFactory jobbuilderfactory;
	
	@Autowired
	StepBuilderFactory stepbuilderfactory;
	
	@Bean
	public Step dopacking()
	{
		return stepbuilderfactory.get("dopacking").tasklet(new Tasklet() {
			
			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				System.out.println("Executing dopacking step");
				return RepeatStatus.FINISHED;
			}
		}).build();
	}
	
	@Bean
	public Step outfordelivery()
	{
		boolean lostaddress=true;
		return stepbuilderfactory.get("outfordelivery").tasklet(new Tasklet() {
			
			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
			
				if(lostaddress)
					throw new RuntimeException("Delivery address not found");
				
				System.out.println("Going out for delivery");
				return RepeatStatus.FINISHED;
			}
		}).build();
	}
	
	
	@Bean
	public Step givepackagetocustomer()
	{
		return stepbuilderfactory.get("givepackagetocustomer").tasklet(new Tasklet() {
			
			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				System.out.println("Package given to customer");
				return RepeatStatus.FINISHED;
			}
		}).build();
	}
	
	@Bean
	public Step bringbacktoGodown()
	{
		return stepbuilderfactory.get("bringbacktogoddown").tasklet(new Tasklet() {
			
			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				System.out.println("package bought back to godown");
				return RepeatStatus.FINISHED;
			}
		}).build();
	}
	
	@Bean
	public Job deliverypackagejob()
	{
		return jobbuilderfactory.get("deliverypackagejob")
				.start(dopacking())
				.next(outfordelivery()).on("FAILED").fail()  //while running remove fail() and repalce with stop()
				.from(outfordelivery()).on("*").to(givepackagetocustomer()).end().build();
		
		
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringBatchProj6BatchStatusControlApplication.class, args);
	}

}
