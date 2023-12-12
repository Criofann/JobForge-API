package org.kainos.ea.validator;

import org.kainos.ea.cli.JobRequest;
import org.kainos.ea.client.*;
import org.kainos.ea.core.JobValidator;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;;

public class JobValidatorTest {
    JobValidator jobValidator = new JobValidator();
    @Test
    public void isValidJob_shouldAssertNull_whenValidEmployee() throws JobNameTooLongException, JobSpecTooLongException,
            JobCapabilityTooLongException, JobBandTooLongException, ResponsibilityTooLongException, NotURLException {
        JobRequest jobRequest = new JobRequest(
                "Software engineer",
                "The specification sumarry",
                "Enginering",
                "band1",
                "put some responsibilities here",
                "https://kainossoftwareltd.sharepoint.com/SitePages/Home.aspx"

        );

        assertNull(jobValidator.isValidJob(jobRequest));
    }
    @Test
    public void isValidJob_shouldThrowJobNameTooLongException_whenNameToLong() {
        JobRequest jobRequest = new JobRequest(
                "Software engineer and too many many many Characters!!!!!!!",
                "The specification sumarry",
                "Enginering",
                "band1",
                "put some responsibilities here",
                "https://kainossoftwareltd.sharepoint.com/SitePages/Home.aspx"
        );

        assertThrows(JobNameTooLongException.class,
                () -> jobValidator.isValidJob(jobRequest));
    }
    @Test
    public void isValidJob_shouldThrowJobSpecTooLongException_whenSpecToLong() {
        JobRequest jobRequest = new JobRequest(
                "Software engineer",
                "The specification sumarry not meant to be" +
                        "Very Very Very Very Very Very Very Very Very Very Very Very" +
                        "Very Very Very Very Very Very Very Very Very Very Very Very" +
                        "looooooooooong",
                "Enginering",
                "band1",
                "put some responsibilities here",
                "https://kainossoftwareltd.sharepoint.com/SitePages/Home.aspx"
        );

        assertThrows(JobSpecTooLongException.class,
                () -> jobValidator.isValidJob(jobRequest));
    }
    @Test
    public void isValidJob_shouldThrowJobCapabilityTooLongException_whenCapabilityToLong() {
        JobRequest jobRequest = new JobRequest(
                "Software engineer",
                "The specification sumarry",
                "a vey long named capability",
                "band1",
                "put some responsibilities here",
                "https://kainossoftwareltd.sharepoint.com/SitePages/Home.aspx"
        );

        assertThrows(JobCapabilityTooLongException.class,
                () -> jobValidator.isValidJob(jobRequest));
    }
    @Test
    public void isValidJob_shouldThrowJobBandTooLongException_whenBandNameToLong() {
        JobRequest jobRequest = new JobRequest(
                "Software engineer",
                "The specification sumarry",
                "Enginering",
                "band Name that is tooooooooo loooong",
                "put some responsibilities here",
                "https://kainossoftwareltd.sharepoint.com/SitePages/Home.aspx"
        );

        assertThrows(JobBandTooLongException.class,
                () -> jobValidator.isValidJob(jobRequest));
    }
    @Test
    public void isValidJob_shouldThrowResponsibilityTooLongException_whenResponsibilitiesToLong() {
        JobRequest jobRequest = new JobRequest(
                "Software engineer ",
                "The specification sumarry",
                "Enginering",
                "band1",
                "responsibilities are not meant to be" +
                        "Very Very Very Very Very Very Very Very Very Very Very Very" +
                        "Very Very Very Very Very Very Very Very Very Very Very Very"+
                        "looooooooooong",
                "https://kainossoftwareltd.sharepoint.com/SitePages/Home.aspx"
        );

        assertThrows(ResponsibilityTooLongException.class,
                () -> jobValidator.isValidJob(jobRequest));
    }
    @Test
    public void isValidJob_shouldThrowNotURLException_whenSharpointLinkIsNotURL() {
        JobRequest jobRequest = new JobRequest(
                "Software engineer ",
                "The specification sumarry",
                "Enginering",
                "band1",
                "responsibilities",
                "notavalidlink"
        );

        assertThrows(NotURLException.class,
                () -> jobValidator.isValidJob(jobRequest));
    }
}
