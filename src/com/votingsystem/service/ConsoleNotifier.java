package com.votingsystem.service;

public class ConsoleNotifier implements Notifier {
    @Override
    public void notify(String message) {
        System.out.println("[NOTIFY] " + message);
    }
}
