package com.votingsystem.dao;

import com.votingsystem.model.Candidate;
import com.votingsystem.model.Vote;
import java.util.Map;

public interface VoteDAO {

    boolean hasVoted(int voterId) throws DAOException;

    void saveVote(Vote vote) throws DAOException;

    Map<Candidate, Integer> getResults() throws DAOException;
}
