package com.exercise3.NZrobot.Configurations;


import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HtmlUnitConfig
{
    @Bean
    public WebClient webClient(){
        return new WebClient(BrowserVersion.CHROME);
    }
}
