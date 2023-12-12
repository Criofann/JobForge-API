package org.kainos.ea.core;

import org.kainos.ea.cli.JobRequest;
import org.kainos.ea.client.*;

import java.net.URL;

public class JobValidator {
    public String isValidJob(JobRequest jobRequest) throws JobNameTooLongException, JobSpecTooLongException, JobCapabilityTooLongException, JobBandTooLongException, ResponsibilityTooLongException, NotURLException {
        if(jobRequest.getRoleName().length()>20){
            throw new JobNameTooLongException();
        }
        if (jobRequest.getSpecification().length() > 100) {
            throw new JobSpecTooLongException();
        }
        if(jobRequest.getCapabilityName().length()>20){
            throw new JobCapabilityTooLongException();
        }
        if(jobRequest.getBandName().length()>20){
            throw new JobBandTooLongException();
        }
        if (jobRequest.getResponsibilities().length() > 100) {
            throw new ResponsibilityTooLongException();
        }

        if (!isURL(jobRequest.getSharepointLink())) {

            throw new NotURLException();
        }
        return null;
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
