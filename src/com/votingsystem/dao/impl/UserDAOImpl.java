package com.votingsystem.dao.impl;

import com.votingsystem.dao.DAOException;
import com.votingsystem.dao.UserDAO;
import com.votingsystem.model.User;
import com.votingsystem.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {

    @Override
    public User findByUsername(String username) throws DAOException {

        String query = "SELECT * FROM users WHERE username = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new User(
                            rs.getInt("user_id"),
                            rs.getString("username"),
                            rs.getString("password_hash"),
                            rs.getString("role")
                    );
                }
            }

        } catch (SQLException e) {
            // Wrap SQL error into DAOException
            throw new DAOException("Error while finding user by username: " + username, e);
        }

        return null;
    }
}
