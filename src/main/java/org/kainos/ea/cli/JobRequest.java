package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JobRequest {
    private String roleName;
    private String specification;
    private String capabilityName;
    private String bandName;
    private String responsibilities;
    private String sharepointLink;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getCapabilityName() {
        return capabilityName;
    }

    public void setCapabilityName(String capabilityName) {
        this.capabilityName = capabilityName;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }

    public String getSharepointLink() {
        return sharepointLink;
    }

    public void setSharepointLink(String sharepointLink) {
        this.sharepointLink = sharepointLink;
    }

    public JobRequest() {
    }

    @JsonCreator
    public JobRequest(
            @JsonProperty("roleName") String roleName,
            @JsonProperty("specification") String specification,
            @JsonProperty("capabilityName") String capabilityName,
            @JsonProperty("bandName") String bandName,
            @JsonProperty("responsibilities") String responsibilities,
            @JsonProperty("sharepointLink") String sharepointLink) {
                this.roleName = roleName;
                this.specification = specification;
                this.capabilityName = capabilityName;
                this.bandName = bandName;
                this.responsibilities = responsibilities;
                this.sharepointLink = sharepointLink;
            }



}

