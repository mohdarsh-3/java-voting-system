package com.votingsystem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.votingsystem.dao.CandidateDAO;
import com.votingsystem.dao.DAOException;
import com.votingsystem.model.Candidate;
import com.votingsystem.util.DBConnection;

public class CandidateDAOImpl implements CandidateDAO {

    @Override
    public List<Candidate> findAll() throws DAOException {
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
        } catch (SQLException e) {
            throw new DAOException("Failed to retrieve candidates", e);
        }
        return candidates;
    }
}
