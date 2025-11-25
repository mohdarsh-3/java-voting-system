package com.votingsystem.service;

import java.time.LocalDateTime;

import com.votingsystem.dao.DAOException;
import com.votingsystem.dao.VoteDAO;
import com.votingsystem.dao.impl.VoteDAOImpl;
import com.votingsystem.model.Vote;

public class VotingService {

    private final VoteDAO voteDAO = new VoteDAOImpl();
    private final Notifier notifier = new ConsoleNotifier();

    public synchronized boolean castVote(int voterId, int candidateId) {
        try {
            if (voteDAO.hasVoted(voterId)) {
                notifier.notify("Voter " + voterId + " already voted.");
                return false;
            }

            Vote vote = new Vote();
            vote.setVoterId(voterId);
            vote.setCandidateId(candidateId);
            vote.setVoteTime(LocalDateTime.now());

            voteDAO.saveVote(vote);

            notifier.notify("Vote recorded for voter " + voterId + " -> candidate " + candidateId);
            return true;

        } catch (DAOException e) {
            e.printStackTrace();
            notifier.notify("Vote failed: " + e.getMessage());
            return false;
        }
    }
}
