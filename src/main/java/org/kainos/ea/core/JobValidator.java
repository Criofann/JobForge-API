package org.kainos.ea.core;

import org.kainos.ea.cli.JobRequest;
import org.kainos.ea.client.ValidationException;


import java.net.URL;

public class JobValidator {
    public void isValidJob(JobRequest jobRequest) throws
            ValidationException {
        int nameLimit = 20;
        int specAndResLimit = 100;
        if (jobRequest.getRoleName().length() > nameLimit) {
            throw new ValidationException("Role name too long");
        }
        if (jobRequest.getJobFamily().length() > nameLimit) {
            throw new ValidationException("Family name too long");
        }
        if (jobRequest.getSpecification().length() > specAndResLimit) {
            throw new ValidationException("Specifiction too long");
        }
        if (jobRequest.getCapabilityName().length() > nameLimit) {
            throw new ValidationException("Capability name too long");
        }
        if (jobRequest.getBandName().length() > nameLimit) {
            throw new ValidationException("Band name too long");
        }
        if (jobRequest.getResponsibilities().length() > specAndResLimit) {
            throw new ValidationException("Responsibilities too long");
        }

        if (!isURL(jobRequest.getSharepointLink())) {

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
