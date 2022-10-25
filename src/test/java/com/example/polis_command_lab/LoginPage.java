package com.example.polis_command_lab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.example.polis_command_lab.Constants.LOGIN_PAGE_TITTLE;

public class LoginPage
{
  By usernameLocator_=By.xpath("//*[@id=\"field_email\"]");
  By passwordLocator_=By.xpath("//*[@id=\"field_password\"]");
  By loginButtonLocator_=By.xpath("//*[@value='Войти в Одноклассники']");

  private final WebDriver driver_;

  public LoginPage(WebDriver driver)
  {
    this.driver_=driver;
    if (!LOGIN_PAGE_TITTLE.equals(driver_.getTitle()))
    {
      throw new IllegalStateException("Not a login page");
    }
  }

  public void typeUsername(String username)
  {
    driver_.findElement(usernameLocator_).sendKeys(username);
  }

  public void typePassword(String password)
  {
    driver_.findElement(passwordLocator_).sendKeys(password);
  }

  public UserPage submitLogin()
  {
    driver_.findElement(loginButtonLocator_).submit();
    return new UserPage(driver_);
  }

  public UserPage loginAs(String username, String password)
  {
    typeUsername(username);
    typePassword(password);
    return submitLogin();
  }
}
