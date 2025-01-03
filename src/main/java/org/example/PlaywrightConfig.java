package org.example;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightConfig {
    private BrowserContext browserContext;
    private Page page;

    PlaywrightConfig() {
        this.browserContext=Playwright.create().chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        ).newContext();
        this.page= browserContext.newPage();
    }

    public BrowserContext getBrowserContext() {
        return browserContext;
    }

    public Page getPage() {
        return page;
    }
}
