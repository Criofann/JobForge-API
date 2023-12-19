package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JobFamilyRequest {
    private String jobFamily;
    private String roleName;

    public String getJobFamily() {
        return jobFamily;
    }

    public void setJobFamily(String jobFamily) {
        this.jobFamily = jobFamily;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    @JsonCreator
    public JobFamilyRequest(
            @JsonProperty("roleName") String roleName,
            @JsonProperty("JobFamily") String jobFamily
    ) {
        this.jobFamily = jobFamily;
        this.roleName = roleName;
    }
}
