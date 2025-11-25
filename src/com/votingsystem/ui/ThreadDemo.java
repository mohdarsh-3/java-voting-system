package com.votingsystem.ui;

import com.votingsystem.dao.UserDAO;
import com.votingsystem.dao.DAOException;
import com.votingsystem.dao.impl.UserDAOImpl;
import com.votingsystem.model.User;
import com.votingsystem.service.VotingService;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        VotingService service = new VotingService();
        UserDAO userDAO = new UserDAOImpl();

        try {
            // uses username 'arsh' which you already inserted
            User user = userDAO.findByUsername("arsh");
            if (user == null) {
                System.out.println("User 'arsh' not found. Insert the user first or change username.");
                return;
            }
            int voterId = user.getUserId();

            // Optional: delete previous votes for repeatable runs (you can also run the DELETE SQL above)
            // Runnable tasks will use this voterId
            Runnable task = () -> {
                boolean result = service.castVote(voterId, 1); // candidateId = 1
                System.out.println(Thread.currentThread().getName() + " -> " + result);
            };

            Thread t1 = new Thread(task, "Thread-1");
            Thread t2 = new Thread(task, "Thread-2");

            t1.start();
            t2.start();

            t1.join();
            t2.join();

            System.out.println("Thread test finished.");

        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
