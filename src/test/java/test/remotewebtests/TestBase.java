package test.remotewebtests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.DriverConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {

    @BeforeEach
    void beforeEach() {
        System.setProperty("environment", System.getProperty("environment","stageData"));

        DriverConfig driverConfig = ConfigFactory.create(DriverConfig.class);

        String environment = System.getProperty("environment");
        String browser = driverConfig.browserName();
        String browserVersion = driverConfig.browserVersion();
        String browserSize = driverConfig.browserSize();
        String remoteUrl = driverConfig.remoteUrl();
        String browserConfig = String.format("We ran on: %s, Browser: %s, version: %s, window size: %s, remoteUrl: %s",
                environment, browser, browserVersion, browserSize, remoteUrl);
        System.out.println(browserConfig);
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = browser;
        Configuration.browserVersion = browserVersion;
        Configuration.browserSize = browserSize;
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.remote = remoteUrl;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void afterEach() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();
    }
}
