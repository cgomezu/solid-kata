package com.codurance.dip;

public class BirthdayGreeter {
    private final Greeter greeter;

    public BirthdayGreeter(Greeter greeter) {
        this.greeter = greeter;
    }

    public void send() {
        greeter.sendGreetings();
    }



}