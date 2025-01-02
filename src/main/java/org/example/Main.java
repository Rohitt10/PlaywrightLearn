package org.example;

import com.microsoft.playwright.*;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            // Launch Chromium in non-headless mode
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false)
                    .setArgs(List.of(
                            "--disable-blink-features=AutomationControlled",
                            "--disable-features=site-per-process",
                            "--disable-infobars",
                            "--enable-features=NetworkService"
                    )));

            BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                    .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36")
                    .setViewportSize(1280, 720)
                    .setExtraHTTPHeaders(Map.of(
                            "Accept-Language", "en-US,en;q=0.9",
                            "Referer", "https://www.google.com/",
                            "Origin", "https://www.google.com/",
                            "Connection", "keep-alive",
                            "Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8",
                            "Accept-Encoding", "gzip, deflate, br",
                            "sec-ch-ua-platform", "Windows",
                            "sec-ch-ua-mobile", "?0",
                            "upgrade-insecure-requests", "1"
                    )));

            context.addInitScript("Object.defineProperty(navigator, 'webdriver', {get: () => undefined});");
            context.addInitScript("window.navigator.permissions.query = (params) => (params.name === 'notifications' ? Promise.resolve({ state: 'denied' }) : window.navigator.permissions.query(params));");
            context.addInitScript("window.navigator.chrome = { runtime: {} };");

            Page page = context.newPage();
            page.navigate("https://example.com");

// Simulate user interaction
            page.mouse().move(100, 200);
            page.mouse().click(150, 300);
            page.keyboard().type("Hello World", new Keyboard.TypeOptions().setDelay(100));
//            Thread.sleep((int) (Math.random() * 2000) + 500); // Random delay

        }

    }
}