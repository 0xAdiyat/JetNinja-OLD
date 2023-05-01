package com.start.jetninja.helper;

import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;


/**
 * This class provides a utility for extracting cookies from HTTP responses using OkHttp client library.
 */
@Component
public class CookieScraper {

    /**
     * Extracts the first cookie value from the response header of an HTTP response.
     *
     * @param response the HTTP response object to extract cookies from
     * @return the cookie value
     * @throws IllegalArgumentException if the response does not contain any cookies
     */
    private static String extractCookie(Response response) {
        List<String> grabbedCookies = response.headers("Set-Cookie");
        if (grabbedCookies.isEmpty()) {
            throw new IllegalArgumentException("Response does not contain any cookies.");
        }
        String mainCookie = grabbedCookies.get(0);
        String[] cookieParts = mainCookie.split("=");
        String cookieValue = cookieParts[1];
        String[] cookieValueParts = cookieValue.split(";");

        return cookieValueParts[0];

    }



    /**
     * Makes an HTTP request to the given URL and extracts the cookie value from the response.
     *
     * @param url the URL to make the request to
     * @return the cookie value
     * @throws IOException if the request fails
     */
    public String getCookie(String url) throws IOException {
        String jbCookie;
        Response response = HttpRequest.getRequest(url);
        jbCookie = extractCookie(response);

     return jbCookie;
    }


}
