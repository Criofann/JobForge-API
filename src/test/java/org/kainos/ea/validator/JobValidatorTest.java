package org.kainos.ea.validator;

import org.kainos.ea.cli.RoleRequest;
import org.kainos.ea.client.ValidationException;
import org.kainos.ea.core.JobValidator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class JobValidatorTest {
    private final JobValidator jobValidator = new JobValidator();
    @Test
    public void isValidJobShouldAssertNullWhenValidEmployee() {
        RoleRequest roleRequest = new RoleRequest(
                "Software engineer",
                "Job Family",
                "The specification sumarry",
                "Enginering",
                "band1",
                "put some responsibilities here",
                "https://kainossoftwareltd.sharepoint.com/SitePages/Home.aspx"

        );

        assertDoesNotThrow(() -> jobValidator.isValidJob(roleRequest));
    }
    @Test
    public void isValidJobShouldThrowJobNameTooLongExceptionWhenNameToLong() {
        RoleRequest roleRequest = new RoleRequest(
                "Software engineer and too many many many Characters!!!!!!!",
                "Job Family",
                "The specification sumarry",
                "Enginering",
                "band1",
                "put some responsibilities here",
                "https://kainossoftwareltd.sharepoint.com/SitePages/Home.aspx"
        );

        assertThrows(ValidationException.class,
                () -> jobValidator.isValidJob(roleRequest));
    }
    @Test
    public void isValidJobShouldThrowJobSpecTooLongExceptionWhenSpecToLong() {
        RoleRequest roleRequest = new RoleRequest(
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
                () -> jobValidator.isValidJob(roleRequest));
    }
    @Test
    public void isValidJobShouldThrowJobCapTooLongExceptionWhenCapToLong() {
        RoleRequest roleRequest = new RoleRequest(
                "Software engineer",
                "Job Family",
                "The specification sumarry",
                "a vey long named capability",
                "band1",
                "put some responsibilities here",
                "https://kainossoftwareltd.sharepoint.com/SitePages/Home.aspx"
        );

        assertThrows(ValidationException.class,
                () -> jobValidator.isValidJob(roleRequest));
    }
    @Test
    public void isValidJobShouldThrowJobBandTooLongExceptionWhenBandToLong() {
        RoleRequest roleRequest = new RoleRequest(
                "Software engineer",
                "Job Family",
                "The specification sumarry",
                "Enginering",
                "band Name that is tooooooooo loooong",
                "put some responsibilities here",
                "https://kainossoftwareltd.sharepoint.com/SitePages/Home.aspx"
        );

        assertThrows(ValidationException.class,
                () -> jobValidator.isValidJob(roleRequest));
    }
    @Test
    public void isValidJobShouldThrowResTooLongExceptionWhenResToLong() {
        RoleRequest roleRequest = new RoleRequest(
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
                () -> jobValidator.isValidJob(roleRequest));
    }
    @Test
    public void isValidJobShouldThrowNotURLExceptionWhenSharpointIsNotURL() {
        RoleRequest roleRequest = new RoleRequest(
                "Software engineer ",
                "Job Family",
                "The specification sumarry",
                "Enginering",
                "band1",
                "responsibilities",
                "notavalidlink"
        );

        assertThrows(ValidationException.class,
                () -> jobValidator.isValidJob(roleRequest));
    }
}
