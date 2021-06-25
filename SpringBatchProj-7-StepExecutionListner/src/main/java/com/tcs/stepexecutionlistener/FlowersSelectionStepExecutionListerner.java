package com.tcs.stepexecutionlistener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class FlowersSelectionStepExecutionListerner implements StepExecutionListener {

	@Override
	public void beforeStep(StepExecution stepExecution) {
		// TODO Auto-generated method stub
		System.out.println("Before executing a step");

	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		// TODO Auto-generated method stub
		System.out.println("After executing a step");
		String flower=stepExecution.getJobParameters().getString("flowertype");
		String status=flower.equalsIgnoreCase("rose")?"TRIM_REQUIRED":"TRIM_NOT_REQUIRED";
		return new ExitStatus(status);
	}

}
