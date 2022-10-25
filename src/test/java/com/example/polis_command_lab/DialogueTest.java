package com.example.polis_command_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

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
    driver_.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }
  @Test
  public void messageSendCheck()
  {
    LoginPage loginPage=new LoginPage(driver_);
    UserPage userPage=loginPage.loginAs(LOGIN_SENDER, PASSWORD_SENDER);
    MessagePage messagePage = userPage.clickMessageButton();
    messagePage = messagePage.sendMessageToReceiver(MESSAGE);
  }
  @Test 
  public void messageReceiveCheck(){
    LoginPage loginPage = new LoginPage(driver_);
    UserPage userPage = loginPage.loginAs(LOGIN_RECEIVER, PASSWORD_RECEIVER);
    MessagePage messagePage = userPage.clickMessageButton();
    Assert.assertEquals(MESSAGE, messagePage.getLastMessageFromSender());
  }
}
