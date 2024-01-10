package org.kainos.ea.validator;

import org.kainos.ea.cli.JobRequest;
import org.kainos.ea.client.ValidationException;
import org.kainos.ea.core.JobValidator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class JobValidatorTest {
    private final JobValidator jobValidator = new JobValidator();
    @Test
    public void isValidJobShouldAssertNullWhenValidEmployee() {
        JobRequest jobRequest = new JobRequest(
                "Software engineer",
                "Job Family",
                "The specification sumarry",
                "Enginering",
                "band1",
                "put some responsibilities here",
                "https://kainossoftwareltd.sharepoint.com/SitePages/Home.aspx"

        );

        assertDoesNotThrow(() -> jobValidator.isValidJob(jobRequest));
    }
    @Test
    public void isValidJobShouldThrowJobNameTooLongExceptionWhenNameToLong() {
        JobRequest jobRequest = new JobRequest(
                "Software engineer and too many many many Characters!!!!!!!",
                "Job Family",
                "The specification sumarry",
                "Enginering",
                "band1",
                "put some responsibilities here",
                "https://kainossoftwareltd.sharepoint.com/SitePages/Home.aspx"
        );

        assertThrows(ValidationException.class,
                () -> jobValidator.isValidJob(jobRequest));
    }
    @Test
    public void isValidJobShouldThrowJobSpecTooLongExceptionWhenSpecToLong() {
        JobRequest jobRequest = new JobRequest(
                "Software engineer",
                "Job Family",
                "The specification sumarry not meant to be"
                        + "Very Very Very Very Very Very Very Very Very Very "
                        + "Very Very Very Very Very Very Very Very Very Very y"
                        + "looooooooooong",
                "Enginering",
                "band1",
                "put some responsibilities here",
                "https://kainossoftwareltd.sharepoint.com/SitePages/Home.aspx"
        );

        assertThrows(ValidationException.class,
                () -> jobValidator.isValidJob(jobRequest));
    }
    @Test
    public void isValidJobShouldThrowJobCapTooLongExceptionWhenCapToLong() {
        JobRequest jobRequest = new JobRequest(
                "Software engineer",
                "Job Family",
                "The specification sumarry",
                "a vey long named capability",
                "band1",
                "put some responsibilities here",
                "https://kainossoftwareltd.sharepoint.com/SitePages/Home.aspx"
        );

        assertThrows(ValidationException.class,
                () -> jobValidator.isValidJob(jobRequest));
    }
    @Test
    public void isValidJobShouldThrowJobBandTooLongExceptionWhenBandToLong() {
        JobRequest jobRequest = new JobRequest(
                "Software engineer",
                "Job Family",
                "The specification sumarry",
                "Enginering",
                "band Name that is tooooooooo loooong",
                "put some responsibilities here",
                "https://kainossoftwareltd.sharepoint.com/SitePages/Home.aspx"
        );

        assertThrows(ValidationException.class,
                () -> jobValidator.isValidJob(jobRequest));
    }
    @Test
    public void isValidJobShouldThrowResTooLongExceptionWhenResToLong() {
        JobRequest jobRequest = new JobRequest(
                "Software engineer ",
                "Job Family",
                "The specification sumarry",
                "Enginering",
                "band1",
                "responsibilities are not meant to be"
                        + "Very Very Very Very Very Very Very Very "
                        + "Very Very Very Very Very Very Very Very Very "
                        + "looooooooooong",
                "https://kainossoftwareltd.sharepoint.com/SitePages/Home.aspx"
        );

        assertThrows(ValidationException.class,
                () -> jobValidator.isValidJob(jobRequest));
    }
    @Test
    public void isValidJobShouldThrowNotURLExceptionWhenSharpointIsNotURL() {
        JobRequest jobRequest = new JobRequest(
                "Software engineer ",
                "Job Family",
                "The specification sumarry",
                "Enginering",
                "band1",
                "responsibilities",
                "notavalidlink"
        );

        assertThrows(ValidationException.class,
                () -> jobValidator.isValidJob(jobRequest));
    }
}
