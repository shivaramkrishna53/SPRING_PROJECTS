package com.tcs.batch;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.SkipListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.jsr.RetryListener;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.json.JacksonJsonObjectMarshaller;
import org.springframework.batch.item.json.builder.JsonFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.TaskExecutor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.tcs.order.Order;
import com.tcs.order.TransformedOrder;

@SpringBootApplication
@EnableBatchProcessing
public class SpringBatchProj23ConfiguringJobsForSkipTestsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchProj23ConfiguringJobsForSkipTestsApplication.class, args);
	}
	
	
	public static final String reading_query="select order_id,first_name,last_name,email,cost,item_id,item_name,ship_date from shipped_order order by order_id";
	public static final String writing_query="insert into shipped_order_output(order_id,first_name,last_name,email,cost,item_id,item_name,ship_date) values(:orderId,:firstName,:lastName,:email,:cost,:itemId,:itemName,:shipDate)";
	@Autowired
	JobBuilderFactory jobbuilderfac;
	
	@Autowired
	StepBuilderFactory stepbuilderfac;
	
	@Autowired
	DataSource ds;
	
	
	
	@Bean
	public Job readingDbAndWritingToDBMultiThreadingProcessorJob()
	{
		return jobbuilderfac.get("RetryItemsSteps").start(readingDbAndWritingToDBMultiThreadingStep()).build();
	}

	@Bean
	public TaskExecutor taskexecutormethod()
	{
		ThreadPoolTaskExecutor te=new ThreadPoolTaskExecutor();
		te.setCorePoolSize(2);
		te.setMaxPoolSize(10);
		return te;
	}
	
	@Bean
	public Step readingDbAndWritingToDBMultiThreadingStep() {
		// TODO Auto-generated method stub
		return stepbuilderfac.get("readingDbAndWritingToDBStep").<Order,TransformedOrder>chunk(10).reader(dbreader()).processor(dotheprocessing()).faultTolerant().retry(Exception.class).retryLimit(3)
				.listener(new org.springframework.retry.RetryListener() {
					
					@Override
					public <T, E extends Throwable> boolean open(RetryContext context, RetryCallback<T, E> callback) {
						// TODO Auto-generated method stub
						if(context.getRetryCount()>0)
						System.out.println("Attempting to Retry::");
						
						return true;
					}
					
					@Override
					public <T, E extends Throwable> void onError(RetryContext context, RetryCallback<T, E> callback,
							Throwable throwable) {
						// TODO Auto-generated method stub
						if(context.getRetryCount()>0)
						System.out.println("An exception has occured:");
						
					}
					
					@Override
					public <T, E extends Throwable> void close(RetryContext context, RetryCallback<T, E> callback,
							Throwable throwable) {
						// TODO Auto-generated method stub
						
					}
				})
				.writer(jdbcwritermethod()).taskExecutor(taskexecutormethod()).build();
	}

	@Bean
	public ItemWriter<TransformedOrder> jdbcwritermethod() {
		
		return new JdbcBatchItemWriterBuilder().dataSource(ds).sql(writing_query).beanMapped().build();
	}

	@Bean
	public ItemProcessor<Order,TransformedOrder> dotheprocessing() {
		return new process();
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
		}).name("jdbccuritmbuildrse").saveState(false).build();
	}

	


}
