package org.kainos.ea.core;

import org.kainos.ea.cli.JobFamilyRequest;
import org.kainos.ea.client.JobFamilyTooLongException;
import org.kainos.ea.client.JobNameTooLongException;

public class JobFamilyValidator {
    public boolean isValidJobFamily(JobFamilyRequest jobFamilyRequest)
            throws JobNameTooLongException, JobFamilyTooLongException {
        System.out.println("validator");
        System.out.println(jobFamilyRequest.getJobFamily());
        System.out.println("here");
        if (jobFamilyRequest.getRoleName().length() > 20) {
            throw new JobNameTooLongException();
        }

        if (jobFamilyRequest.getJobFamily().length() > 20) {
            System.out.println("job Familt too long");
            throw new JobFamilyTooLongException();
        }
        return true;
    }
}
