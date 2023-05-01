package com.start.jetninja;

import com.start.jetninja.utils.CookieScraper;
import com.start.jetninja.utils.HttpRequest;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JetNinjaApplication {
    @Autowired
    private static CookieScraper  cookieScraper;
    public static void main(String[] args) throws Exception {
        SpringApplication.run(JetNinjaApplication.class, args);

    }

}
