package com.hellokoding.account;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class SmokeTest {

    @Test
    public void smokeTest() {
        RestTemplate restTemplate = new RestTemplate();

        String homePage = restTemplate.getForObject(url("/login"), String.class);

        assertThat(homePage, containsString("Log in"));

        String registration = restTemplate.getForObject(url("/registration"), String.class);

        assertThat(registration, containsString("Create your account"));
    }

    private String url(String path) {
        String baseUrl = "http://localhost:8080";
        String envUrl = System.getenv("ACCOUNT_URL");

        if (envUrl != null && !envUrl.isEmpty()) {
            baseUrl = envUrl;
        }

        return baseUrl + path;
    }
}
