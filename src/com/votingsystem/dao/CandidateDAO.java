package com.votingsystem.dao;

import com.votingsystem.model.Candidate;
import java.sql.SQLException;
import java.util.List;

public interface CandidateDAO {

    List<Candidate> findAll() throws SQLException;

}
