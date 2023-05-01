// Import necessary packages and classes
package com.start.jetninja;
import com.start.jetninja.utils.CookieScraper;
import com.start.jetninja.utils.HttpRequest;
import okhttp3.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.io.IOException;

// Define the class and implement CommandLineRunner interface
@Component
public class GetAccount implements CommandLineRunner {

    // Create instance variables for required classes
    private final CookieScraper cookieScraper;
    private final HttpRequest httpRequest;

    // Constructor for dependency injection
    public GetAccount(CookieScraper cookieScraper, HttpRequest httpRequest) {
        this.cookieScraper = cookieScraper;
        this.httpRequest = httpRequest;
    }

    // Override the run method to execute the code
    @Override
    public void run(String... args) {

        try {
            // Get cookie from the specified URL
            String cookie = cookieScraper.getCookie("https://account.jetbrains.com/signup");

            // Print the retrieved cookie
            System.out.println(cookie);

            // Send a verification link to the email
            Response jbResponse = httpRequest.postRequest("https://account.jetbrains.com/signup-request?_st=" + cookie, "_st-JBA=" + cookie);

            // Get the response status code
            int responseStatus = jbResponse.code();

            // Check the response status code
            if (responseStatus != 200) {
                System.out.println("ERROR");
            } else {
                System.out.println("okkkk");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
