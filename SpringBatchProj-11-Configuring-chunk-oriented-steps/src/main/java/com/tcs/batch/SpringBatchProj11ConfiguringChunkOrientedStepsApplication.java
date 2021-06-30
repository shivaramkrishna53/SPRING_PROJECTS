package com.tcs.batch;

import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableBatchProcessing
public class SpringBatchProj11ConfiguringChunkOrientedStepsApplication {

	@Autowired
	JobBuilderFactory jobbuilderfac;
	@Autowired
	StepBuilderFactory stepbuilderfac;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBatchProj11ConfiguringChunkOrientedStepsApplication.class, args);
	}
	
	@Bean
	public ItemReader<String> Itemread() {
		// TODO Auto-generated method stub
		
		return new ItemreaderImpl();
	}

	
	@Bean
	public Step chunkbasedstep()
	{
		return stepbuilderfac.get("chunkbasedstep").<String,String>chunk(3).reader(Itemread()).writer(new ItemWriter<String>() {

			@Override
			public void write(List<? extends String> items) throws Exception {
				// TODO Auto-generated method stub
				System.out.println("size of items::"+ items.size());
				items.forEach(System.out::println);
				
			}
		}).build();
	}
	

	@Bean
	public Job chunkjob()
	{
	  return jobbuilderfac.get("chunkjob").start(chunkbasedstep()).build();	
	}

}
