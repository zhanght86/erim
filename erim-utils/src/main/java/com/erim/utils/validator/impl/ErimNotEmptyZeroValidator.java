package com.erim.utils.validator.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.erim.utils.validator.ErimNotEmptyZero;

/**
 * 
 * @author Jeff
 * 2011-8-30
 */
public class ErimNotEmptyZeroValidator implements ConstraintValidator<ErimNotEmptyZero, Integer> {

    @Override
    public void initialize(ErimNotEmptyZero parameters) {
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        return value != null && value != 0;
    }
}