package com.tcs.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.batch.core.job.flow.support.SimpleFlow;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tcs.decider.IsCustomerAtHomeDecider;
import com.tcs.decider.iscorrectitemDecider;

@SpringBootApplication
@EnableBatchProcessing
public class SpringBatchProj9NestingJobsApplication {

	@Autowired
	JobBuilderFactory jobbuilderfac;
	
	@Autowired
	StepBuilderFactory stepbuilderfac;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBatchProj9NestingJobsApplication.class, args);
	}
	
	@Bean
	public Job PackageShipmentJob()
	{
		
		return jobbuilderfac.get("PackageShipmentJob").start(nestedbillingjobstep()).next(packingStep()).on("*").to(deliveryFlow()).end().build();
	}
	
	@Bean
	public Flow deliveryFlow()
	{
		String addrs="begumpet";
		return new FlowBuilder<SimpleFlow>("deliveryflow").start(deliveringtoaddressStep(addrs))
				.on("FAILED").to(storepackageStep())
				.from(deliveringtoaddressStep(addrs)).on("*").to(iscustomerathome())
				.on("customer_absent").to(leavepackageatdoorStep())
				.from(iscustomerathome()).on("customer_present").to(packageatcustomer()).next(iscorrectitem())
				.on("correct_item").to(Thankthecustomer())
				.from(iscorrectitem()).on("*").to(GiveRefundtocustomer()).build();
	}
	
	@Bean
	public Step nestedbillingjobstep()
	{
		return stepbuilderfac.get("nestedbillingjobstep").job(billingjob()).build();
	}
	
	@Bean
	public Step invoicegeneration()
	{
		return stepbuilderfac.get("invoicegenstep").tasklet(new Tasklet() {
			
			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				// TODO Auto-generated method stub
				System.out.println("Invoice generated successfully");
				return RepeatStatus.FINISHED;
			}
		}).build();
	}
	
	@Bean
	public Job billingjob()
	{
		return jobbuilderfac.get("billingjob").start(invoicegeneration()).build();
	}
	
	
	@Bean
	public JobExecutionDecider iscustomerathome()
	{
		return new IsCustomerAtHomeDecider();
	}
	
	@Bean
	public JobExecutionDecider iscorrectitem()
	{
		return new iscorrectitemDecider();
	}
	
	
	
	
	@Bean
	public Step packingStep()
	{
		return stepbuilderfac.get("packingStep").tasklet(new Tasklet() {
			
			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				// TODO Auto-generated method stub
				System.out.println("Packing the parcel");
				return RepeatStatus.FINISHED;
			}
		}).build();
	}
	
	@Bean
	public Step deliveringtoaddressStep(String loc)
	{
		return stepbuilderfac.get("deliveringtoaddressStep").tasklet(new Tasklet() {
			
			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				// TODO Auto-generated method stub
				if(!loc.equalsIgnoreCase("begumpet"))
				throw new RuntimeException("Address not found");
				
				System.out.println("Address Found:Deliverying");
				return RepeatStatus.FINISHED;
			}
		}).build();
	}
	
	
	@Bean
	public Step storepackageStep()
	{
		return stepbuilderfac.get("storepackageStep").tasklet(new Tasklet() {
			
			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				// TODO Auto-generated method stub
				System.out.println("store the parcel at godown");
				return RepeatStatus.FINISHED;
			}
		}).build();
	}
	
	@Bean
	public Step leavepackageatdoorStep()
	{
		return stepbuilderfac.get("leavepackageatdoorStep").tasklet(new Tasklet() {
			
			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				// TODO Auto-generated method stub
				System.out.println("leavepackageatdoor");
				return RepeatStatus.FINISHED;
			}
		}).build();
	}
	
	@Bean
	public Step packageatcustomer()
	{
		return stepbuilderfac.get("packageatcustomerStep").tasklet(new Tasklet() {
			
			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				// TODO Auto-generated method stub
				System.out.println("package at customer");
				return RepeatStatus.FINISHED;
			}
		}).build();
	}
	
	@Bean
	public Step Thankthecustomer()
	{
		return stepbuilderfac.get("ThankthecustomerStep").tasklet(new Tasklet() {
			
			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				// TODO Auto-generated method stub
				System.out.println("Thanking the customer");
				return RepeatStatus.FINISHED;
			}
		}).build();
	}
	
	@Bean
	public Step GiveRefundtocustomer()
	{
		return stepbuilderfac.get("GiveRefundtocustomerStep").tasklet(new Tasklet() {
			
			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				// TODO Auto-generated method stub
				System.out.println("Giving Refund to customer");
				return RepeatStatus.FINISHED;
			}
		}).build();
		
		
		
	}
	

}
