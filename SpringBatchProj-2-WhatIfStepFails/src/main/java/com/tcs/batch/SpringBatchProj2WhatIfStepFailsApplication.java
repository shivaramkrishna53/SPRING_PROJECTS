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
public class SpringBatchProj2WhatIfStepFailsApplication {

	@Autowired
	JobBuilderFactory jobbuilderfactory;
	
	@Autowired
	StepBuilderFactory stepbuilderfactory;
	
	@Bean
	public Step doproductpacking()
	{
		return this.stepbuilderfactory.get("ProductPacking").tasklet(new Tasklet() {
			
			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				String itemstored=chunkContext.getStepContext().getJobParameters().get("item").toString();
				System.out.println("product packing step is packed on:"+itemstored);
				
				return RepeatStatus.FINISHED;
			}
		}).build();
		
		
	}
	
	
	@Bean
	public Step gotocustomeraddress()
	{
		return this.stepbuilderfactory.get("goingtocustomeraddress").tasklet(new Tasklet() {
			boolean lostway=false;
			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				if(lostway)
				{
					throw new RuntimeException("Lost the way while delivering package");
				}
				System.out.println("GoingtoCustomerAddress");
				return RepeatStatus.FINISHED;
			}
		}).build();
	}
	
	@Bean
	public Step givepackagetocustomer()
	{
		return this.stepbuilderfactory.get("givepackagetocustomer").tasklet(new Tasklet() {
			
			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				System.out.println("Givepackagetocustomer");
				return RepeatStatus.FINISHED;
			}
		}).build();
	}
	
	@Bean
	public Job getjob()
	{
		return this.jobbuilderfactory.get("ProductDelivery").start(doproductpacking()).next(gotocustomeraddress()).next(givepackagetocustomer()).build();
		
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchProj2WhatIfStepFailsApplication.class, args);
	}

}
