package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return id == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // TODO: Add custom toString method
    @Override
    public String toString() {
        if ((name == null || name.equals("")) &&
                (employer == null || employer.getValue() == null) &&
                (location == null || location.getValue() == null) &&
                (positionType == null || positionType.getValue() == null) &&
                (coreCompetency == null || coreCompetency.getValue() == null)) {
            return "OOPS! This job does not seem to exist.";
        } else {
            String nanMessage = "Data not available";
            String output = "\n";
            output += "ID: " + id + "\n";
            output += "Name: " + (name == null || name.equals("") ? nanMessage : name)  + "\n";
            output += "Employer: " + (employer == null || employer.getValue() == null ? nanMessage : employer) + "\n";
            output += "Location: " + (location == null || location.getValue() == null ? nanMessage : location) + "\n";
            output += "Position Type: " + (positionType == null || positionType.getValue() == null ? nanMessage : positionType) + "\n";
            output += "Core Competency: " + (coreCompetency == null || coreCompetency.getValue() == null ? nanMessage : coreCompetency) + "\n";
            output += "\n";
            return output;
        }
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
