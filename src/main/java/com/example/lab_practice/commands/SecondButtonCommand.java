package com.example.lab_practice.commands;

public class SecondButtonCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Second button");
    }
}
