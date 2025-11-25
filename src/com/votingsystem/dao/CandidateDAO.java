package com.votingsystem.dao;
import java.util.List;

import com.votingsystem.model.Candidate;

public interface CandidateDAO {
    List<Candidate> findAll() throws DAOException;
}
