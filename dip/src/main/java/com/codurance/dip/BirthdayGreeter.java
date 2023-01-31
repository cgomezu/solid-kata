package com.codurance.dip;

public class BirthdayGreeter {
    private final SendGreeter sendGreeter;

    public BirthdayGreeter(SendGreeter sendGreeter) {
        this.sendGreeter = sendGreeter;
    }

    public void send() {
        sendGreeter.sendGreetings();
    }



}