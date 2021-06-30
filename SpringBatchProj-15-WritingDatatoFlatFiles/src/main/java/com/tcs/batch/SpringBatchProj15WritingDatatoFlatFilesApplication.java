package com.tcs.batch;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.file.transform.FieldExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.RowMapper;

import com.tcs.order.Order;

@SpringBootApplication
@EnableBatchProcessing
public class SpringBatchProj15WritingDatatoFlatFilesApplication {

	public static final String query="select order_id,first_name,last_name,email,cost,item_id,item_name,ship_date from shipped_order order by order_id";
	
	public String[] names=new String[] {"orderId","firstName","lastName","email","cost","itemId","itemName","shipDate"};
	@Autowired
	JobBuilderFactory jobbuilderfac;
	
	@Autowired
	StepBuilderFactory stepbuilderfac;
	
	@Autowired
	DataSource ds;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBatchProj15WritingDatatoFlatFilesApplication.class, args);
	}
	
	@Bean
	public Job readingfromdbandwritingtoflatfileJob()
	{
		return jobbuilderfac.get("readingfromdbandwritingtoflatfileJob").start(stepMethod()).build();
	}
	
	@Bean
	public Step stepMethod()
	{
		return stepbuilderfac.get("readingandwritingstep").<Order,Order>chunk(10).reader(readfromdb()).writer(writetocsv()).build();
	}
    
	

	@Bean
	public ItemReader<Order> readfromdb() {
		// TODO Auto-generated method stub
		return new JdbcCursorItemReaderBuilder<Order>().dataSource(ds).sql(query).name("jdbcitemrdrbildr") .rowMapper(new RowMapper<Order>() {

			@Override
			public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Order or=new Order();
				or.setCost(rs.getBigDecimal("cost"));
				or.setEmail(rs.getString("email"));
				or.setFirstName(rs.getString("first_name"));
				or.setItemId(rs.getString("item_id"));
				or.setItemName(rs.getString("item_name"));
				or.setLastName(rs.getString("last_name"));
				or.setOrderId(rs.getLong("order_id"));
				or.setShipDate(rs.getDate("ship_date"));
				
				return or;
			}
		}).build();
	}
	
	@Bean
	public ItemWriter<Order> writetocsv() {
		// TODO Auto-generated method stub
		FlatFileItemWriter<Order> fltfilewrtr=new FlatFileItemWriter<Order>();
		fltfilewrtr.setResource(new FileSystemResource("E:\\shiva java developer full stack\\springprojects\\SpringBatchProj-15-WritingDatatoFlatFiles\\src\\main\\java\\com\\tcs\\outputcsv\\csvoutput.csv"));
		
		DelimitedLineAggregator<Order> aggregator=new DelimitedLineAggregator<Order>();
		aggregator.setDelimiter(",");
		
		BeanWrapperFieldExtractor<Order> fieldExtractor=new BeanWrapperFieldExtractor<Order>();
		fieldExtractor.setNames(names);
		
		aggregator.setFieldExtractor(fieldExtractor);
		
		fltfilewrtr.setLineAggregator(aggregator);
		
		return fltfilewrtr;
	}
	
	

}
