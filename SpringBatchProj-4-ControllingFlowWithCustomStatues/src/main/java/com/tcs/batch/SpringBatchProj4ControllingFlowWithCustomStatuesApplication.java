package com.tcs.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tcs.decider.DeliveryDecider;

@SpringBootApplication
@EnableBatchProcessing
public class SpringBatchProj4ControllingFlowWithCustomStatuesApplication {

	@Autowired
	JobBuilderFactory jobbuilderfactory;
	
	@Autowired
	StepBuilderFactory stepbuilderfactory;
	
	@Bean
	public JobExecutionDecider getcustomjobstatus()
	{
		return new DeliveryDecider();
	}
	
	
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
		boolean lostaddress=false;
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
	public Step leaveatthedoor()
	{
		return stepbuilderfactory.get("leaveatthedoor").tasklet(new Tasklet() {
			
			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				System.out.println("Package leave at the door");
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
				.next(outfordelivery()).on("FAILED").to(bringbacktoGodown())
				.from(outfordelivery()).on("*").to(getcustomjobstatus()).on("CUSTOMER_PRESENT").to(givepackagetocustomer())
				.from(getcustomjobstatus()).on("CUSTOMER_LEFT").to(leaveatthedoor())
				.end().build();
		
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBatchProj4ControllingFlowWithCustomStatuesApplication.class, args);
	}

}
