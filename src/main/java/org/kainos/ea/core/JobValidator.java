package org.kainos.ea.core;

import org.kainos.ea.cli.RoleRequest;
import org.kainos.ea.client.ValidationException;


import java.net.URL;

public class JobValidator {
    public void isValidJob(RoleRequest roleRequest) throws
            ValidationException {
        int nameLimit = 20;
        int specAndResLimit = 100;
        if (roleRequest.getRoleName().length() > nameLimit) {
            throw new ValidationException("Role name too long");
        }
        if (roleRequest.getJobFamily().length() > nameLimit) {
            throw new ValidationException("Family name too long");
        }
        if (roleRequest.getSpecification().length() > specAndResLimit) {
            throw new ValidationException("Specifiction too long");
        }
        if (roleRequest.getCapabilityName().length() > nameLimit) {
            throw new ValidationException("Capability name too long");
        }
        if (roleRequest.getBandName().length() > nameLimit) {
            throw new ValidationException("Band name too long");
        }
        if (roleRequest.getResponsibilities().length() > specAndResLimit) {
            throw new ValidationException("Responsibilities too long");
        }

        if (!isURL(roleRequest.getSharepointLink())) {

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
