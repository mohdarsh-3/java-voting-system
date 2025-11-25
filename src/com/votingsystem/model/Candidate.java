package com.votingsystem.model;

public class Candidate {
    private int candidateId;
    private String name;
    private String party;
    private String description;

    public Candidate() {}

    public Candidate(int candidateId, String name, String party, String description) {
        this.candidateId = candidateId;
        this.name = name;
        this.party = party;
        this.description = description;
    }

    public int getCandidateId() { return candidateId; }
    public void setCandidateId(int candidateId) { this.candidateId = candidateId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getParty() { return party; }
    public void setParty(String party) { this.party = party; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
