package com.tcs.batch;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.RowMapper;

import com.tcs.order.Order;

@SpringBootApplication
@EnableBatchProcessing
public class SpringBatchProj13ReadingFromDatabasesInSingleThreadApplication {

	@Autowired
	JobBuilderFactory jobbuilderfac;
	
	@Autowired
	StepBuilderFactory stepbuilderfac;
	
	@Autowired
	DataSource ds;
	
	public static final String query="select order_id, first_name, last_name, email, cost, item_id, item_name, ship_date from springdb.shipped_order order by order_id";
	public static void main(String[] args) {
		SpringApplication.run(SpringBatchProj13ReadingFromDatabasesInSingleThreadApplication.class, args);
	}
	
	@Bean
	public Job readingfromdbJob()
	{
		return jobbuilderfac.get("readingfromdbjob").start(readfromdbStep()).build();
	}
	
	@Bean
	public Step readfromdbStep()
	{
		return stepbuilderfac.get("readfromdbStep").<Order,Order>chunk(5).reader(itemReaderMethod()).writer(new ItemWriter<Order>() {

			@Override
			public void write(List<? extends Order> items) throws Exception {
				// TODO Auto-generated method stub
				System.out.println("Chunk size is:"+items.size());
				items.forEach(System.out::println);
				
			}
		}).build();
	}

	@Bean
	public ItemReader<Order> itemReaderMethod() {
			return new JdbcCursorItemReaderBuilder<Order>()
			.dataSource(ds)
			.sql(query)
			.name("jdbcitemrdrbuildr")
			.rowMapper(new RowMapper<Order>() {
				
				@Override
				public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
					// TODO Auto-generated method stub
					Order or=new Order();
					or.setOrderId(rs.getLong("order_id"));
					or.setFirstName(rs.getString("first_name"));
					or.setLastName(rs.getString("last_name"));
					or.setEmail(rs.getString("email"));
					or.setCost(rs.getBigDecimal("cost"));
					or.setItemId(rs.getString("item_id"));
					or.setItemName(rs.getString("item_name"));
					or.setShipDate(rs.getDate("ship_date"));

					return or;
				}
			}).build();
			
		
	}
	
	
	

}
