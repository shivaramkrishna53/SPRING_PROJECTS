package com.tcs.batch;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.json.JacksonJsonObjectMarshaller;
import org.springframework.batch.item.json.builder.JsonFileItemWriterBuilder;
import org.springframework.batch.item.support.builder.CompositeItemProcessorBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.RowMapper;

@SpringBootApplication
@EnableBatchProcessing
public class SpringBatchProj22ChainingItemProcessorFreeShippingChallangeApplication {

	@Autowired
	JobBuilderFactory jbf;
	
	@Autowired
	StepBuilderFactory sbf;
	
	@Autowired 
	DataSource ds;
	
	private static final String query="select * from shipped_order";
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBatchProj22ChainingItemProcessorFreeShippingChallangeApplication.class, args);
	    
	
	}
	
	@Bean
	public Job chainingitemprocessoorchallangejob()
	{
		return jbf.get("chainingitemprocessoorchallangejob").start(chainingitemprocessoorchallangeStep()).build();
	}
	
	public Step chainingitemprocessoorchallangeStep()
	{
		return sbf.get("chainingitemprocessoorchallangeStep").<Order,TransformedOrder>chunk(10).reader(read()).processor(doprocessing()).writer(jsonwriter()).build();
	}

	
    @Bean
	public ItemReader<Order> read() {
		// TODO Auto-generated method stub
		return new JdbcCursorItemReaderBuilder().name("jdbccurreader").dataSource(ds).sql(query).rowMapper(new RowMapper<Order>() {

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
	public ItemProcessor<Order, TransformedOrder> doprocessing() {
		// TODO Auto-generated method stub
		return new CompositeItemProcessorBuilder().delegates(dotransformation(),doprocessingforfreeshipping(),doprocessingforemail()).build();
	}

    @Bean
    public ItemProcessor<Order,TransformedOrder> dotransformation() {
		// TODO Auto-generated method stub
    	
    	
		return new ItemProcessor<Order, TransformedOrder>() {
			
			@Override
			public TransformedOrder process(Order item) throws Exception {
				// TODO Auto-generated method stub
				TransformedOrder transor=new TransformedOrder(item);
				Random rand=new Random();
				transor.setTrackingid(rand.nextLong());
				return transor;
			}
		};
	}

	@Bean
	public ItemProcessor<TransformedOrder,TransformedOrder> doprocessingforemail() {
		// TODO Auto-generated method stub
    	return new ItemProcessor<TransformedOrder, TransformedOrder>() {

			@Override
			public TransformedOrder process(TransformedOrder item) throws Exception {
				// TODO Auto-generated method stub
				String emailid=item.getEmail();
				if(emailid.contains(".gov"))
					item.setIsShipping("free");
				return item;
			}
    		
		};
	}

    @Bean
	public ItemProcessor<TransformedOrder,TransformedOrder> doprocessingforfreeshipping() {
		return new ItemProcessor<TransformedOrder, TransformedOrder>() {

			@Override
			public TransformedOrder process(TransformedOrder item) throws Exception {
				// TODO Auto-generated method stub
				if(item.getCost().intValue() >80)
					item.setIsShipping("free");
				else
					item.setIsShipping("not free");
				
				return item;
			}
		};
		
	}
    
    
    @Bean
	public ItemWriter<TransformedOrder> jsonwriter() {
		// TODO Auto-generated method stub
		
		return new JsonFileItemWriterBuilder<TransformedOrder>().append(true).resource(new FileSystemResource("E:\\shiva java developer full stack\\springprojects\\SpringBatchProj-22-ChainingItemProcessor-FreeShippingChallange\\src\\main\\java\\com\\tcs\\result\\abcd.json")).jsonObjectMarshaller(new JacksonJsonObjectMarshaller<TransformedOrder>()).name("jsonitmwriterewew").build();
	}

	
}
