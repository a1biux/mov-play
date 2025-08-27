package com.a1biux.play.web.controller;

import com.a1biux.play.domain.service.MovPlayAiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {

    private final String platform;
    private final MovPlayAiService aiService;

    public HelloControler(@Value("${spring.application.name}") String platform, MovPlayAiService aiService) {
        this.platform = platform;
        this.aiService = aiService;
    }

    @GetMapping("/hello")
    public String Hello() {
        return this.aiService.generateGreeting(platform);
    }
}
