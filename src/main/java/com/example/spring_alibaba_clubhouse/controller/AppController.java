package com.example.spring_alibaba_clubhouse.controller;

import java.util.AbstractMap;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class AppController {

    @Value("${app.name: default-app-name}")
    private String appName;

    private HashMap<String, String> map;

    @GetMapping("/app-name")
    public AbstractMap<? extends String, ? extends String> getAppName() {
        if (map == null) {
            map = new HashMap<>();
            map.put("server-name", this.appName);
            map.put("status", "ok");
        }
        return map;
    }
}
