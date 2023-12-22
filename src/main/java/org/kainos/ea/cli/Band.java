package org.kainos.ea.cli;

public class Band {
    private String bandName;
    private String bandLevel;
    private String competencies;
    
    public Band(String bandName,
                String bandLevel, String competencies) {
        this.bandName = bandName;
        this.bandLevel = bandLevel;
        this.competencies = competencies;
    }

    public Band(String bandName,
                String bandLevel,String competencies) {
        this.bandName = bandName;
        this.bandLevel = bandLevel;
        this.competencies = competencies;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public String getBandLevel() {
        return bandLevel;
    }

    public void setBandLevel(String bandLevel) {
        this.bandLevel = bandLevel;
    }

    public String getCompetencies() {
        return competencies;
    }

    public void setCompetencies(String competencies) {
        this.competencies = competencies;
    }
}
