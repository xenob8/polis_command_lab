package com.example.polis_command_lab;

import org.openqa.selenium.By;

import java.time.Duration;

public interface IDriverDecorator {
    void waitVisible(By by, Duration duration);
}
