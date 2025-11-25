package com.votingsystem.dao;
import com.votingsystem.model.User;

public interface UserDAO {
    User findByUsername(String username) throws DAOException;
}
