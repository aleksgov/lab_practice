package com.example.lab_practice.commands;

public class FirstButtonCommand implements Command {
    @Override
    public void execute() {
        System.out.println("First button ");
    }
}
