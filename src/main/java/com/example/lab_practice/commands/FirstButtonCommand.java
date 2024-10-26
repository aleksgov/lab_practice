package com.example.lab_practice.commands;

import com.example.lab_practice.ScenesGenerator;

public class FirstButtonCommand implements Command {
    private final ScenesGenerator scenesGenerator = ScenesGenerator.getInstance();
    @Override
    public void execute() {
        scenesGenerator.setFirstLabMainScreenScene();
    }
}
