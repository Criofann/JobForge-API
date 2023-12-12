package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JobFamilyRequest {
    private String JobFamily;
    private String RoleName;

    public String getJobFamily() {
        return JobFamily;
    }

    public void setJobFamily(String jobFamily) {
        JobFamily = jobFamily;
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String roleName) {
        RoleName = roleName;
    }
    @JsonCreator
    public JobFamilyRequest(
            @JsonProperty("roleName") String roleName,
            @JsonProperty("JobFamily") String jobFamily
    )
    {
        this.JobFamily = jobFamily;
        this.RoleName = roleName;
    }
}
