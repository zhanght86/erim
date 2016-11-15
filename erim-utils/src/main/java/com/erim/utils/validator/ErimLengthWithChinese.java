package com.erim.utils.validator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.erim.utils.validator.impl.ErimLengthWithChineseValidator;

/**
 * 
 * @author Jeff
 * 2011-8-30
 */
@Documented
@Constraint(validatedBy = ErimLengthWithChineseValidator.class)
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
public @interface ErimLengthWithChinese {
    int min() default 0;

    int max() default Integer.MAX_VALUE;

    int maxChinese() default 0;

    String message() default "{errors.lengthWithChinese.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
    @Retention(RUNTIME)
    @Documented
    public @interface List {
        ErimLengthWithChinese[] value();
    }

}