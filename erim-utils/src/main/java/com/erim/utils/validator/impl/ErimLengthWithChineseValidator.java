package com.erim.utils.validator.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.erim.utils.lang.StringUtils;
import com.erim.utils.validator.ErimLengthWithChinese;

/**
 * 
 * @author Jeff
 * 2011-8-30
 */
public class ErimLengthWithChineseValidator implements ConstraintValidator<ErimLengthWithChinese, String> {
    private int min;
    private int max;
    private int maxChinese;

    @Override
    public void initialize(ErimLengthWithChinese parameters) {
        min = parameters.min();
        max = parameters.max();
        maxChinese = parameters.maxChinese();
        validateParameters();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return true;
        }
        int length = StringUtils.lengthWithChinese(value);
        return length >= min && length <= max;
    }

    private void validateParameters() {
        if (min < 0) {
            throw new IllegalArgumentException("The min parameter cannot be negative.");
        }
        if (max < 0) {
            throw new IllegalArgumentException("The max parameter cannot be negative.");
        }
        if (max < min) {
            throw new IllegalArgumentException("The length cannot be negative.");
        }
        if (maxChinese > max) {
            throw new IllegalArgumentException("The maxChinese length is invalid.");
        }
    }
}