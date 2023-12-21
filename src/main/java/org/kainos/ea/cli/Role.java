package org.kainos.ea.cli;

public class Role {
    private String roleName;
    private String specification;
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

    public Role (String roleName, String specification,
                 String responsibilities, String sharepointLink) {
        this.roleName = roleName;
        this.specification = specification;
        this.responsibilities = responsibilities;
        this.sharepointLink = sharepointLink;
    }
}
