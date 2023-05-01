package com.start.jetninja;

import com.start.jetninja.helper.CookieScraper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JetNinjaApplication {
    @Autowired
    private static CookieScraper  cookieScraper;
    public static void main(String[] args) throws Exception {
        SpringApplication.run(JetNinjaApplication.class, args);
        cookieScraper.run();
    }

}
