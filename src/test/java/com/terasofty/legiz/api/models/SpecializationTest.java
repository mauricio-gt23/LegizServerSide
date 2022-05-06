package com.terasofty.legiz.api.models;

import com.terasofty.legiz.api.domain.models.Specialization;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class SpecializationTest {
    public Validator validator;
    @BeforeEach
    void setUp() {
        var validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void whenNotNullName() {
        Specialization specialization = new Specialization(null, "MEMBER");
        Set<ConstraintViolation<Specialization>> violations = validator.validate(specialization);
        Assertions.assertEquals(violations.size(), 0);
    }
}
