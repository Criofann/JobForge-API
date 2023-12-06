package org.kainos.ea.core;

import org.kainos.ea.cli.JobRequest;

import java.net.URL;

public class JobValidator {
    public String isValidJob(JobRequest jobRequest){
        if(jobRequest.getRoleName().length()>20){
            return "name greater than 20 charactors";
        }
        if (jobRequest.getSpecification().length() > 100) {
            return "spec greater than 100 charactors";
        }
        if(jobRequest.getCapabilityName().length()>20){
            return "name greater than 20 charactors";
        }
        if(jobRequest.getBandName().length()>20){
            return "name greater than 20 charactors";
        }
        if (jobRequest.getResponsibilities().length() > 100) {
            return "spec greater than 100 charactors";
        }

        if (!isURL(jobRequest.getSharepointLink())) {

            return "Not a valid link";
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
