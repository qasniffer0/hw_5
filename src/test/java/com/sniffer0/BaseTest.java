package com.sniffer0;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

abstract class BaseTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }
}
