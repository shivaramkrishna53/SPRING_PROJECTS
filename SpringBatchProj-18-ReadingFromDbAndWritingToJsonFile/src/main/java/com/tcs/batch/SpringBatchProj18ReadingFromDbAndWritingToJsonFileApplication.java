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
import org.springframework.batch.item.json.JacksonJsonObjectMarshaller;
import org.springframework.batch.item.json.builder.JsonFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.RowMapper;

import com.tcs.order.Order;

@SpringBootApplication
@EnableBatchProcessing
public class SpringBatchProj18ReadingFromDbAndWritingToJsonFileApplication {

	public static final String reading_query="select order_id,first_name,last_name,email,cost,item_id,item_name,ship_date from shipped_order order by order_id";

	@Autowired
	JobBuilderFactory jobbuilderfac;
	
	@Autowired
	StepBuilderFactory stepbuilderfac;
	
	@Autowired
	DataSource ds;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBatchProj18ReadingFromDbAndWritingToJsonFileApplication.class, args);
	}
	
	@Bean
	public Job readingDbAndWritingToJsonJob()
	{
		return jobbuilderfac.get("readingDbAndWritingToJsonJob").start(readingDbAndWritingToJsonStep()).build();
	}

	@Bean
	public Step readingDbAndWritingToJsonStep() {
		// TODO Auto-generated method stub
		return stepbuilderfac.get("readingDbAndWritingToJsonStep").<Order,Order>chunk(100).reader(dbreader()).writer(jsonwriter()).build();
	}

	@Bean
	public ItemReader<Order> dbreader() {
		// TODO Auto-generated method stub
		return new JdbcCursorItemReaderBuilder().dataSource(ds).sql(reading_query).rowMapper(new RowMapper<Order>() {

			@Override
			public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
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
		}).name("jdbccuritmbuildr").build();
	}

	@Bean
	public ItemWriter<Order> jsonwriter() {
		// TODO Auto-generated method stub
		
		return new JsonFileItemWriterBuilder<Order>().resource(new FileSystemResource("E:\\shiva java developer full stack\\springprojects\\SpringBatchProj-18-ReadingFromDbAndWritingToJsonFile\\src\\main\\java\\com\\tcs\\output\\output_data.json")).jsonObjectMarshaller(new JacksonJsonObjectMarshaller<Order>()).name("jsonitmwriter").build();
	}

	
}
