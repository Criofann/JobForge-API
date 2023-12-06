package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JobFamilyRequest {
    private String Jobfamily;
    private String RoleName;

    public String getJobfamily() {
        return Jobfamily;
    }

    public void setJobfamily(String jobfamily) {
        Jobfamily = jobfamily;
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
            @JsonProperty("JobFamily") String jobfamily
    )
    {
        this.Jobfamily = jobfamily;
        this.RoleName = roleName;
    }
}
