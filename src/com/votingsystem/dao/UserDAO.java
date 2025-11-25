package com.votingsystem.dao;

import com.votingsystem.model.User;
import java.sql.SQLException;

public interface UserDAO {
    User findByUsername(String username) throws SQLException;
}
