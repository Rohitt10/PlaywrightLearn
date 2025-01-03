package org.example;

import com.microsoft.playwright.*;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        PlaywrightConfig config = new PlaywrightConfig();
        Page page=config.getBrowserContext().newPage();
        page.navigate("https://zoom.us/signin");
        PlaywrightUtils playwrightUtils = new PlaywrightUtils();
        Page.ScreenshotOptions screenshotOptions = new Page.ScreenshotOptions();
        playwrightUtils.takeScreenshot(page);
        page.waitForTimeout(3000);
        page.close();
        config.getBrowserContext().close();



    }
}