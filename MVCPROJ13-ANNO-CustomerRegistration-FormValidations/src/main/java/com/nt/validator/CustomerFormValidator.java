package com.nt.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.model.Customer;
@Component("custform")
public class  CustomerFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz.isAssignableFrom(Customer.class); //to check wheather the right form is coming for which we have written the validations
		
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Customer c=(Customer)target;
		if(c.getCname()==null || c.getCname().isBlank())
			errors.rejectValue("cname", "name.required");
		else
			if(c.getCname().length()<5)
				errors.rejectValue("cname", "name.minlen");
			else
				if(c.getCadd()==null || c.getCadd().isBlank())
					errors.rejectValue("cadd", "add.required");
				else
					if(c.getCadd().length()<5)
						errors.rejectValue("cadd", "add.minlen");
					else
						if(c.getBillamnt()==null)
							errors.rejectValue("billamnt", "billamnt.required");
						else
							if(c.getBillamnt()<=0)
								errors.rejectValue("billamnt", "billamnt.positive");
			
			

	}

}
