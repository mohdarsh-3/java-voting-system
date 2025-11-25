package com.votingsystem.service;

public class EmailNotifier implements Notifier {
    @Override
    public void notify(String message) {
        // demonstration only — no real email
        System.out.println("[EMAIL-FAKE] " + message);
    }
}
