package org.kainos.ea.core;

import org.kainos.ea.cli.JobFamilyRequest;
import org.kainos.ea.cli.JobRequest;

public class JobFamilyValidator {
    public String isValidJobFamily(JobFamilyRequest jobFamilyRequest) {
        if (jobFamilyRequest.getRoleName().length() > 20) {
            return "name greater than 20 charactors";
        }

        if (jobFamilyRequest.getJobfamily().length() > 20) {
            return "name greater than 20 charactors";
        }
        return null;
    }
}
