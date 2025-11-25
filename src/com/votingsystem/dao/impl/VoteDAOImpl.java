package com.votingsystem.dao.impl;

import com.votingsystem.dao.DAOException;
import com.votingsystem.dao.VoteDAO;
import com.votingsystem.model.Candidate;
import com.votingsystem.model.Vote;
import com.votingsystem.util.DBConnection;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class VoteDAOImpl implements VoteDAO {

    @Override
    public boolean hasVoted(int voterId) throws DAOException {
        String sql = "SELECT COUNT(*) FROM votes WHERE voter_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, voterId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }

        } catch (SQLException e) {
            throw new DAOException("Error checking if voter has voted", e);
        }
        return false;
    }

    @Override
    public void saveVote(Vote vote) throws DAOException {
        String sql = "INSERT INTO votes (voter_id, candidate_id, vote_time) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, vote.getVoterId());
            ps.setInt(2, vote.getCandidateId());
            ps.setTimestamp(3, Timestamp.valueOf(vote.getVoteTime()));
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Error saving vote", e);
        }
    }

    @Override
    public Map<Candidate, Integer> getResults() throws DAOException {
        Map<Candidate, Integer> results = new HashMap<>();

        String sql =
            "SELECT c.candidate_id, c.name, c.party, c.description, COUNT(v.vote_id) AS votes " +
            "FROM candidates c LEFT JOIN votes v ON c.candidate_id = v.candidate_id " +
            "GROUP BY c.candidate_id, c.name, c.party, c.description";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Candidate c = new Candidate(
                        rs.getInt("candidate_id"),
                        rs.getString("name"),
                        rs.getString("party"),
                        rs.getString("description")
                );
                results.put(c, rs.getInt("votes"));
            }

        } catch (SQLException e) {
            throw new DAOException("Error fetching voting results", e);
        }

        return results;
    }
}
