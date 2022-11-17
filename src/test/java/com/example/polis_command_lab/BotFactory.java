package com.example.polis_command_lab;

import com.example.polis_command_lab.valueobject.TestBot;

import java.util.HashMap;
import java.util.Map;

public class BotFactory {
    private final Map<String, TestBot> cache = new HashMap<>();
    public BotFactory(){
        TestBot sender = new TestBot("technoPol2", "technoPolis2022",
                "Bot Sender");
        TestBot receiver = new TestBot("technoPol30", "technoPolis2022",
                "Bot Receiver");
        cache.put("SENDER", sender);
        cache.put("RECEIVER", receiver);
    }

    public TestBot get(String key){
        return cache.get(key);
    }
}
