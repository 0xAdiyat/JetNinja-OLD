// Import necessary packages and classes
package com.start.jetninja.utils;
import okhttp3.*;
import org.springframework.stereotype.Component;
import java.io.IOException;

// Define the class and mark it as a component
@Component
public class HttpRequest {

    // Create a static OkHttpClient object
    private static final OkHttpClient client = new OkHttpClient();

    // Method to send GET requests and return the response
    public Response getRequest(String url) throws IOException {
        // Build the GET request using the provided URL
        Request request = new Request.Builder()
                .url(url)
                .build();

        // Execute the request and retrieve the response
        try (Response response = client.newCall(request).execute()) {
            // If the response is not successful, throw an IOException
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            // Return the response
            return response;
        }
    }


    // Method to send POST requests with a cookie and return the response

    public Response postRequest(String url, String cookie, String temp_mail) throws  IOException{
        // Build the POST request body
        RequestBody body = new FormBody.Builder()
                .add("email", temp_mail)
                .build();

        // Build the POST request using the provided URL, cookie, and request body
        Request request = new Request.Builder()
                .url(url)
                .header("Cookie", cookie)
                .post(body)
                .build();

        // Execute the request and retrieve the response
        try (Response response = client.newCall(request).execute()) {
            // If the response is not successful, throw an IOException
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            // Print the response body for debugging purposes

            // Return the response
            return response;
        }
    }
    public String getRequestWBody(String url) throws IOException {
        // Build the GET request using the provided URL
        Request request = new Request.Builder()
                .url(url)
                .build();

        // Execute the request and retrieve the response
        try (Response response = client.newCall(request).execute()) {
            // If the response is not successful, throw an IOException
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);


            return response.body().string();
        }
    }


    public String getRequestWBodyJBSign(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        Response response = client.newCall(request).execute();
        CookieExtractor cookieExtractor = new CookieExtractor();
        String cookie = cookieExtractor.getCookie(response);
        System.out.println("Cookie: "+cookie);
        Request request2 = new Request.Builder()
                .url("https://account.jetbrains.com/signup-complete")
                .addHeader("Cookie", "JSESSIONID-JBA="+cookie)
                .build();
        System.out.println("JSESSIONID-JBA="+cookie);
        Response response2 = client.newCall(request2).execute();
        String string = response2.body().string();
        System.out.println(string);
        return string;

    }
}
