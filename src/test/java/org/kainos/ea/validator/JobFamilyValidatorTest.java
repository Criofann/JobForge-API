package org.kainos.ea.validator;

import org.junit.jupiter.api.Test;
import org.kainos.ea.cli.JobFamilyRequest;
import org.kainos.ea.cli.JobRequest;
import org.kainos.ea.client.*;
import org.kainos.ea.core.JobFamilyValidator;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JobFamilyValidatorTest {
    JobFamilyValidator jobFamilyValidator = new JobFamilyValidator();
    @Test
    public void isValidJob_shouldAssertNull_whenValidEmployee() throws JobNameTooLongException, JobFamilyTooLongException {
        JobFamilyRequest jobFamilyRequest = new JobFamilyRequest(
                "Software engineer",
                "engineering"
        );

        assertNull(jobFamilyValidator.isValidJobFamily(jobFamilyRequest));
    }
    @Test
    public void isValidJob_shouldThrowRole_whenValidEmployee() {
        JobFamilyRequest jobFamilyRequest = new JobFamilyRequest(
                "Software engineer",
                "a job family name that is tooo long"
        );

        assertThrows(JobFamilyTooLongException.class,
                () -> jobFamilyValidator.isValidJobFamily(jobFamilyRequest));
    }

}
