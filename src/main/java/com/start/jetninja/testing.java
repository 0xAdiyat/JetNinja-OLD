package com.start.jetninja;

import com.start.jetninja.utils.CookieExtractor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class testing {
    private static final OkHttpClient client = new OkHttpClient();

    public static void getRequestWBodyJBSign(String url) throws IOException {
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
//                .addHeader("Cookie", "JSESSIONID-JBA="+cookie)
                .addHeader("Cookie", "JSESSIONID-JBA=E4BB792A2E6C420F3C6D8694FB511CA1")
                .build();
        System.out.println("JSESSIONID-JBA="+cookie);
        Response response2 = client.newCall(request2).execute();
        String string = response2.body().string();
        System.out.println(string);

    }

    public static void main(String[] args) {
        try {
            getRequestWBodyJBSign("https://account.jetbrains.com/signup-complete/dtv29gwi2ssgraycw4wjtb1dc");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
