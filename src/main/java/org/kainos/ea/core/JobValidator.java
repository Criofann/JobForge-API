package org.kainos.ea.core;

import org.kainos.ea.cli.JobRole;
import org.kainos.ea.client.ValidationException;


import java.net.URL;

public class JobValidator {
    public void isValidJob(JobRole jobRole) throws
            ValidationException {
        int nameLimit = 20;
        int specAndResLimit = 100;
        if (jobRole.getRoleName().length() > nameLimit) {
            throw new ValidationException("Role name too long");
        }
        if (jobRole.getJobFamily().length() > nameLimit) {
            throw new ValidationException("Family name too long");
        }
        if (jobRole.getSpecification().length() > specAndResLimit) {
            throw new ValidationException("Specifiction too long");
        }
        if (jobRole.getCapabilityName().length() > nameLimit) {
            throw new ValidationException("Capability name too long");
        }
        if (jobRole.getBandName().length() > nameLimit) {
            throw new ValidationException("Band name too long");
        }
        if (jobRole.getResponsibilities().length() > specAndResLimit) {
            throw new ValidationException("Responsibilities too long");
        }

        if (!isURL(jobRole.getSharepointLink())) {

            throw new ValidationException("Not a valid URL");
        }
    }

    private boolean isURL(String sharepointLink) {
        try {
            new URL(sharepointLink);
            return true;
        } catch (Exception e) {
            return false;
        }
}
}
