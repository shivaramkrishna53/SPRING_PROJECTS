package com.tcs.batch;

import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;

import com.tcs.order.Order;

@SpringBootApplication
@EnableBatchProcessing
public class SpringBatchProj12ReadingFlatFilesApplication {

	@Autowired
	JobBuilderFactory jobbuilderfac;
	
	@Autowired
	StepBuilderFactory stepbuilderfac;
	
	private static final String tokens[]= new String[] {"order_id","first_name","last_name","email","cost","item_id","item_name","ship_date"};
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBatchProj12ReadingFlatFilesApplication.class, args);
	}
	
	@Bean
	public ItemReader<Order> itemread() {
		FlatFileItemReader<Order> itemreader=new FlatFileItemReader<Order>();
		itemreader.setLinesToSkip(1);
		itemreader.setResource(new FileSystemResource("E:\\shiva java developer full stack\\springprojects\\SpringBatchProj-12-ReadingFlatFiles\\src\\main\\java\\com\\tcs\\batch\\shipped_orders.csv"));
		
		DelimitedLineTokenizer tokenizer=new DelimitedLineTokenizer(); // it is used to break the line to different tokens based on(,)comma
	    tokenizer.setNames(tokens); //the used to map which position of the csv file corresponds to the  header values

	    DefaultLineMapper<Order> linemapper=new DefaultLineMapper<Order>(); //the use of defaultLinemapper is to take the line from the file and how to map the fields to a pojo(Order)

	    linemapper.setLineTokenizer(tokenizer); 
	       
	     linemapper.setFieldSetMapper(new OrderFieldSetMapper());    //instruct the linemapper on how to create the order object using the tokens passed by the delimetedLineTokenzer
	     
	     itemreader.setLineMapper(linemapper);
	     return itemreader;
	}
	
	@Bean
	public Step flatitemreaderStep()
	{
		return stepbuilderfac.get("flatitemreaderStep").<Order,Order>chunk(3).reader(itemread()).writer(new ItemWriter<Order>() {

			@Override
			public void write(List<? extends Order> items) throws Exception {
				// TODO Auto-generated method stub
				System.out.println("ItemWriter step the size of the chunk is:"+items.size());
				items.forEach(System.out::println);
				
				
			}
		}).build();
	}
	
	
	

	@Bean
	public Job readingDataFromFileJob()
	{
		return jobbuilderfac.get("readingDataFromFileJob").start(flatitemreaderStep()).build();
	}

}
