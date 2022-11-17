package com.example.polis_command_lab.test;

import com.example.polis_command_lab.BotFactory;
import com.example.polis_command_lab.page.LoginPage;
import com.example.polis_command_lab.page.MessagePage;
import com.example.polis_command_lab.page.UserPage;
import com.example.polis_command_lab.valueobject.TestBot;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SendMsgAndCheckItTest extends BaseTest {

    private static final BotFactory BOT_FACTORY = new BotFactory();

    private static final TestBot SENDER = BOT_FACTORY.get("SENDER");
    private static final TestBot RECEIVER = BOT_FACTORY.get("RECEIVER");


    @ParameterizedTest
    @ValueSource(strings = {"Hello"})
    @DisplayName("send message by Sender and check it with Receiver")
    public void messageSendCheck(String msg) {
        LoginPage loginPage = new LoginPage(driver);
        UserPage userPage = loginPage.loginAs(SENDER);
        assertThat(userPage.getUserName(), equalTo(SENDER.getUsername()));
        MessagePage messagePage = userPage.clickMessageButton();
        messagePage.getDialogByName(RECEIVER.getUsername()).click();
        messagePage.activeTypeField().typeMessage(msg).sumbitMessage();

        driver.quit();
        driver = getNewDriver();

        driver.get(URL);
        loginPage = new LoginPage(driver);
        userPage = loginPage.loginAs(RECEIVER);
        assertThat(userPage.getUserName(), equalTo(RECEIVER.getUsername()));
        messagePage = userPage.clickMessageButton();
        assertThat(messagePage.getDialogByName(SENDER.getUsername()).lastMsg, equalTo(msg));
    }


}
