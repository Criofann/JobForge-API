package org.kainos.ea.cli;

public class Role {
    private String RoleName;
    private String Specification;
    private String Responsibilities;
    private String SharepointLink;

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String roleName) {
        RoleName = roleName;
    }

    public String getSpecification() {
        return Specification;
    }

    public void setSpecification(String specification) {
        Specification = specification;
    }

    public String getResponsibilities() {
        return Responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        Responsibilities = responsibilities;
    }

    public String getSharepointLink() {
        return SharepointLink;
    }

    public void setSharepointLink(String sharepointLink) {
        SharepointLink = sharepointLink;
    }

    public Role(String RoleName, String Specification, String Responsibilities, String SharepointLink) {
        this.RoleName = RoleName;
        this.Specification = Specification;
        this.Responsibilities = Responsibilities;
        this.SharepointLink = SharepointLink;
    }
}
