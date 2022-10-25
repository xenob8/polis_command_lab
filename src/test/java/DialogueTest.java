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
  public void messageCheck()
  {
    setup();
    LoginPage loginPage = new LoginPage(driver_);
    MessagePage messagePage = (loginPage.loginAs(LOGIN_SENDER, PASSWORD_SENDER)).clickMessageButton();
    messagePage = messagePage.sendMessageToReceiver(MESSAGE);
    driver_.close();
    setup();
    loginPage = new LoginPage(driver_);
    MessagePage messagePage = (loginPage.loginAs(LOGIN_RECEIVER, PASSWORD_RECEIVER).clickMessageButton;
    Assert.assertEquals(messagePage.getLastMessageFromSender, MESSAGE);
  }
}
