package com.start.jetninja;

import com.start.jetninja.helper.CookieScraper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JetNinjaApplication {
    @Autowired
    private static CookieScraper  cookieScraper;
    public static void main(String[] args) throws Exception {
        SpringApplication.run(JetNinjaApplication.class, args);

        CookieScraper cookieScraper = new CookieScraper();
        String cookie = cookieScraper.getCookie("https://account.jetbrains.com/signup");
        System.out.println(cookie);




    }

}
