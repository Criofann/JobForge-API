package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RoleRequest {
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

    @JsonCreator
    public RoleRequest(
            @JsonProperty("RoleName") String roleName,
            @JsonProperty("Specification") String specification,
            @JsonProperty("CapabilityName") String capabilityName,
            @JsonProperty("BandName") String bandName,
            @JsonProperty("Responsibilities") String responsibilities,
            @JsonProperty("SharepointLink") String sharepointLink) {
        this.roleName = roleName;
        this.specification = specification;
        this.capabilityName = capabilityName;
        this.bandName = bandName;
        this.responsibilities = responsibilities;
        this.sharepointLink = sharepointLink;

    }
}
