package com.votingsystem.model;

public class Admin extends User {
    private String adminCode;

    public Admin() { super(); }

    public Admin(int userId, String username, String passwordHash, String role, String adminCode) {
        super(userId, username, passwordHash, role);
        this.adminCode = adminCode;
    }

    public String getAdminCode() { return adminCode; }
    public void setAdminCode(String adminCode) { this.adminCode = adminCode; }

    @Override
    public String toString() {
        return "Admin: " + getUsername() + " (code=" + adminCode + ")";
    }
}
