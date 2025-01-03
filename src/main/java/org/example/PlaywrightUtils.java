package org.example;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

import java.nio.file.Paths;
import java.time.Instant;

public class PlaywrightUtils {

    public void takeScreenshot(Page page) {
        Page.ScreenshotOptions screenshotOptions = new Page.ScreenshotOptions();
        page.screenshot(screenshotOptions.setPath(Paths.get("./screenshots/" + Instant.now() + "_" + "id.png")));
    }
}
