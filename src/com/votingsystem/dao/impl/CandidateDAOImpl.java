package com.votingsystem.dao.impl;

import com.votingsystem.dao.CandidateDAO;
import com.votingsystem.model.Candidate;
import com.votingsystem.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CandidateDAOImpl implements CandidateDAO {

    @Override
    public List<Candidate> findAll() throws SQLException {
        List<Candidate> candidates = new ArrayList<>();

        String query = "SELECT * FROM candidates";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Candidate candidate = new Candidate(
                        rs.getInt("candidate_id"),
                        rs.getString("name"),
                        rs.getString("party"),
                        rs.getString("description")
                );
                candidates.add(candidate);
            }
        }
        return candidates;
    }
}
