package com.springs.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.springs.domain.Enrichment;

@Component
public class CustomValidator implements Validator {

	   @Override
	   public boolean supports(Class clazz) {
	      return Enrichment.class.isAssignableFrom(clazz);
	   }

	   @Override
	   public void validate(Object target, Errors errors) {
	      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "compTypeId", "Enter valid Component Type");

	   }

	}
