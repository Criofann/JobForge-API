package org.kainos.ea.validator;

import org.junit.jupiter.api.Test;
import org.kainos.ea.cli.JobFamilyRequest;

import org.kainos.ea.core.JobFamilyValidator;
import org.kainos.ea.client.JobNameTooLongException;
import org.kainos.ea.client.JobFamilyTooLongException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class JobFamilyValidatorTest {
    private final JobFamilyValidator jobFamilyValidator
            = new JobFamilyValidator();
    @Test
    public void isValidJobShouldAssertNullWhenValidEmployee()
            throws JobNameTooLongException, JobFamilyTooLongException {
        JobFamilyRequest jobFamilyRequest = new JobFamilyRequest(
                "Software engineer",
                "engineering"
        );

        assertTrue(jobFamilyValidator.isValidJobFamily(jobFamilyRequest));
    }
    @Test
    public void isValidJobShouldThrowRoleWhenValidEmployee() {
        JobFamilyRequest jobFamilyRequest = new JobFamilyRequest(
                "Software engineer",
                "a job family name that is tooo long"
        );

        assertThrows(JobFamilyTooLongException.class,
                () -> jobFamilyValidator.isValidJobFamily(jobFamilyRequest));
    }

}
