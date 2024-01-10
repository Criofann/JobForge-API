package org.kainos.ea.cli;

public class Band {
    private String BandName;
    private String BandLevel;
    private String Competencies;

    public String getBandName() {
        return BandName;
    }

    public void setBandName(String bandName) {
        BandName = bandName;
    }

    public String getBandLevel() {
        return BandLevel;
    }

    public void setBandLevel(String bandLevel) {
        BandLevel = bandLevel;
    }

    public String getCompetencies() {
        return Competencies;
    }

    public void setCompetencies(String competencies) {
        Competencies = competencies;
    }

    public Band(String BandName, String BandLevel, String Competencies) {
        this.BandName = BandName;
        this.BandLevel = BandLevel;
        this.Competencies = Competencies;
    }
}
