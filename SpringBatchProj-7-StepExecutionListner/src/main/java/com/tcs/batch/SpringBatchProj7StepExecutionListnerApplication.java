package com.tcs.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecutionListener;
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

import com.tcs.stepexecutionlistener.FlowersSelectionStepExecutionListerner;

@SpringBootApplication
@EnableBatchProcessing
public class SpringBatchProj7StepExecutionListnerApplication {

	@Autowired
	JobBuilderFactory jobbuilderfac;
	
	@Autowired
	StepBuilderFactory stepbuilderfac;
	
	@Bean
	public StepExecutionListener flowerstepexecutionlistner()
	{
		return new FlowersSelectionStepExecutionListerner();
	}
	
	@Bean
	public Step selectflower()
	{
		return stepbuilderfac.get("selectflowerstep").tasklet(new Tasklet() {
			
			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				System.out.println("selectflowerstep");
				return RepeatStatus.FINISHED;
			}
		}).listener(flowerstepexecutionlistner()).build();
	}
	
	@Bean
	public Step trim()
	{
		return stepbuilderfac.get("trimStep").tasklet(new Tasklet() {
			
			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				System.out.println("Triming Done");
				return RepeatStatus.FINISHED;
			}
		}).build();
	}
	
	@Bean
	public Step arrangeflowers()
	{
		return stepbuilderfac.get("arrangeflowersStep").tasklet(new Tasklet() {
			
			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				System.out.println("FlowersGotArranged");
				return RepeatStatus.FINISHED;
			}
		}).build();
	}
	
	@Bean
	public Job FlowerShopJob()
	{
	  return jobbuilderfac.get("FlowerShopJob").start(selectflower())
			  .on("TRIM_REQUIRED").to(trim()).next(arrangeflowers())
			  .from(selectflower()).on("TRIM_NOT_REQUIRED").to(arrangeflowers())
			  .end().build();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBatchProj7StepExecutionListnerApplication.class, args);
	}

}
