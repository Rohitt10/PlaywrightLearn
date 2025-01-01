package org.example;

import com.microsoft.playwright.*;

import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            // Launch Chromium in non-headless mode
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            // Create a new browser page
            Page page = browser.newPage();

            // Navigate to the Zoom sign-in page
            page.navigate("https://zoom.us/signin");
            page.locator("Email Address").fill("a@gmail.com");
            // Optional: Keep the browser open
            System.out.println("Browser opened successfully!");
        }

    }
}