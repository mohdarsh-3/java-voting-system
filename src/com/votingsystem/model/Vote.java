package com.votingsystem.model;

import java.time.LocalDateTime;

public class Vote {
    private int voteId;
    private int voterId;
    private int candidateId;
    private LocalDateTime voteTime;

    public Vote() {}

    public Vote(int voteId, int voterId, int candidateId, LocalDateTime voteTime) {
        this.voteId = voteId;
        this.voterId = voterId;
        this.candidateId = candidateId;
        this.voteTime = voteTime;
    }

    public int getVoteId() { return voteId; }
    public void setVoteId(int voteId) { this.voteId = voteId; }

    public int getVoterId() { return voterId; }
    public void setVoterId(int voterId) { this.voterId = voterId; }

    public int getCandidateId() { return candidateId; }
    public void setCandidateId(int candidateId) { this.candidateId = candidateId; }

    public LocalDateTime getVoteTime() { return voteTime; }
    public void setVoteTime(LocalDateTime voteTime) { this.voteTime = voteTime; }
}
