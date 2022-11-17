package com.example.polis_command_lab;
import com.example.polis_command_lab.test.SendMsgAndCheckItTest;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({SendMsgAndCheckItTest.class})
public class Runner {

}