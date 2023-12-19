package org.kainos.ea.core;

import org.kainos.ea.cli.JobRequest;
import org.kainos.ea.client.JobBandTooLongException;
import org.kainos.ea.client.JobNameTooLongException;
import org.kainos.ea.client.JobSpecTooLongException;
import org.kainos.ea.client.ResponsibilityTooLongException;
import org.kainos.ea.client.NotURLException;
import org.kainos.ea.client.JobCapabilityTooLongException;

import java.net.URL;

public class JobValidator {
    public Boolean isValidJob(JobRequest jobRequest) throws
            JobNameTooLongException, JobSpecTooLongException,
            JobBandTooLongException, ResponsibilityTooLongException,
            NotURLException, JobCapabilityTooLongException {
        int nameLimit = 20;
        int specAndResLimit = 100;
        if (jobRequest.getRoleName().length() > nameLimit) {
            throw new JobNameTooLongException();
        }
        if (jobRequest.getSpecification().length() > specAndResLimit) {
            throw new JobSpecTooLongException();
        }
        if (jobRequest.getCapabilityName().length() > nameLimit) {
            throw new JobCapabilityTooLongException();
        }
        if (jobRequest.getBandName().length() > nameLimit) {
            throw new JobBandTooLongException();
        }
        if (jobRequest.getResponsibilities().length() > specAndResLimit) {
            throw new ResponsibilityTooLongException();
        }

        if (!isURL(jobRequest.getSharepointLink())) {

            throw new NotURLException();
        }
        return true;
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