package org.kainos.ea.core;
import org.kainos.ea.cli.RoleRequest;

public final class RoleValidator {
    public static String isValidRole(RoleRequest role) {
        if (role.getBandName().length() > 100) {
            return "Name greater than 100 characters";
        }
        if (role.getCapabilityName().length() > 100) {
            return "Name greater than 100 characters";
        }
        if (role.getResponsibilities().length() < 10) {
            return "Too few Responsibilities";
        }
        if (role.getSpecification().length() < 10) {
            return "Specification too short";
        }
        if (role.getSharepointLink().length() < 10) {
            return "Link too short not valid";
        }
        return null;
    }

    private RoleValidator() {
    }
}
