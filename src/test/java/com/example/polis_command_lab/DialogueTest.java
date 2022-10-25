package com.example.polis_command_lab;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.example.polis_command_lab.Constants.*;


public class DialogueTest
{
  public WebDriver driver_;
  public DialogueTest()
  {
  }

  @Before
  public void setup()
  {
    System.setProperty(DRIVER_NAME, DRIVER_PATH);
    driver_ = new FirefoxDriver();
    driver_.get(URL);
  }
  @Test
  public void messageSendCheck()
  {
    setup();
    LoginPage loginPage=new LoginPage(driver_);
    UserPage userPage = loginPage.loginAs(LOGIN_SENDER, PASSWORD_SENDER);
    driver_.close();
  }
  @Test
  public void messageReceiveCheck(){
    setup();
    LoginPage loginPage = new LoginPage(driver_);
    MessagePage messagePage = (loginPage.loginAs(LOGIN_RECEIVER, PASSWORD_RECEIVER)).clickMessageButton();
    Assert.assertEquals(messagePage.getLastMessageFromSender(), MESSAGE);
    driver_.close();
  }
}
