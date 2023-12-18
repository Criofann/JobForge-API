package org.kainos.ea.cli;

public class BandRole {
    private String RoleName;
    private String Specification;
    private String Responsibilities;
    private String SharepointLink;
    private String BandLevel;

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

    public String getBandLevel() {
        return BandLevel;
    }

    public void setBandLevel(String bandLevel) {
        BandLevel = bandLevel;
    }

    public BandRole(String RoleName, String Specification, String Responsibilities, String SharepointLink, String BandLevel) {
        this.RoleName = RoleName;
        this.Specification = Specification;
        this.Responsibilities = Responsibilities;
        this.SharepointLink = SharepointLink;
        this.BandLevel = BandLevel;
    }
}
