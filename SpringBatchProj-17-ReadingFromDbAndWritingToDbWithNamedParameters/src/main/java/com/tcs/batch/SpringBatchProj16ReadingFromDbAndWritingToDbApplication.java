package com.tcs.batch;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;import java.util.Map;
import java.util.stream.Stream;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.tcs.order.Order;

@SpringBootApplication
@EnableBatchProcessing
public class SpringBatchProj16ReadingFromDbAndWritingToDbApplication {

	public static final String reading_query="select order_id,first_name,last_name,email,cost,item_id,item_name,ship_date from shipped_order order by order_id";
	public static final String writing_query="insert into shipped_order_output(order_id,first_name,last_name,email,cost,item_id,item_name,ship_date) values(:orderId,:firstName,:lastName,:email,:cost,:itemId,:itemName,:shipDate)";

	
	@Autowired
	JobBuilderFactory jobbuilderfac;
	@Autowired
	StepBuilderFactory stepbuilderfac;
	
	@Autowired
	DataSource ds;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBatchProj16ReadingFromDbAndWritingToDbApplication.class, args);
	}
	
	@Bean
	public Job readfromdbandwritetodbJob()
	{
		return jobbuilderfac.get("readfromdbandwritetodbJob").start(readfromdbandwritetodbStep()).build();
	}
	
	@Bean
	public Step readfromdbandwritetodbStep()
	{
		return stepbuilderfac.get("readfromdbandwritetodbStep").<Order,Order>chunk(10).reader(readFromaDb()).writer(writetoanotherDb()).build();
	}

	@Bean
	public ItemReader<Order> readFromaDb() {
		// TODO Auto-generated method stub
		
		return new JdbcCursorItemReaderBuilder<Order>().sql(reading_query).dataSource(ds).name("jdbccuritmrdr").rowMapper(new RowMapper<Order>() {
			
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
	public ItemWriter<Order> writetoanotherDb() {
		// TODO Auto-generated method stub
		
		return new JdbcBatchItemWriterBuilder().dataSource(ds).sql(writing_query).beanMapped().build();
	}

	

}
