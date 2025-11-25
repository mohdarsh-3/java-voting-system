package com.votingsystem.ui;

import com.votingsystem.dao.CandidateDAO;
import com.votingsystem.dao.impl.CandidateDAOImpl;
import com.votingsystem.model.Candidate;

import java.util.List;

public class App {
    public static void main(String[] args) {
        try {
            CandidateDAO candidateDAO = new CandidateDAOImpl();
            List<Candidate> list = candidateDAO.findAll();

            System.out.println("===== Candidate List =====");
            for (Candidate c : list) {
                System.out.println(c.getCandidateId() + ". " + c.getName() + " (" + c.getParty() + ")");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
