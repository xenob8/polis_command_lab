package com.example.polis_command_lab.valueobject;

public class TestBot {

  private final String login;
  private final String password;
  private final String username;

  public TestBot(String login, String password, String username) {
    this.login = login;
    this.password = password;
    this.username = username;
  }

  public String getLogin() {
    return login;
  }

  public String getPassword() {
    return password;
  }

  public String getUsername() {
    return username;
  }
}
