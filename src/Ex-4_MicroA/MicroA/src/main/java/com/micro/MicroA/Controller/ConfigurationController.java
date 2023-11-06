package com.micro.MicroA.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigurationController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${custom.api.url}")
    private String customApiUrl;

    @Value("${spring.application.welcomeMessage}")
    private String welcomeMessage;

    @Value("${spring.datasource.url}")
    private String databaseUrl;

    @GetMapping()
    public String getConfiguration() {
        return "Dev Configuration:\n" +
                welcomeMessage + "\n" +
                "Server Port: " + serverPort + "\n" +
                "Custom API URL: " + customApiUrl + "\n" +
                "Database Url: " + databaseUrl;
    }

}
