package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = BrowserstackDriver.class.getName();
        Configuration.browserSize = null;
        Configuration.timeout = 30000;

    }

    @BeforeEach
    void beforeEach(TestInfo testInfo) {
        String platform = testInfo.getTags().stream()
                .filter(tag -> tag.equals("android") || tag.equals("ios"))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(
                        "Each mobile test must be tagged with android or ios"));
        System.setProperty("platform", platform);

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        String sessionId = Selenide.sessionId().toString();
        System.out.println(sessionId);
       // Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.addVideo(sessionId);
        closeWebDriver();
        System.clearProperty("platform");
    }
}
