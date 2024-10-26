package com.example.lab_practice.commands;

import com.example.lab_practice.ScenesGenerator;

public class SecondButtonCommand implements Command {
    private final ScenesGenerator scenesGenerator = ScenesGenerator.getInstance();
    @Override
    public void execute() {
        scenesGenerator.setStageScene(scenesGenerator.getMainScreenScene());
    }
}
