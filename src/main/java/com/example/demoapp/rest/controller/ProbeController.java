package com.example.demoapp.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProbeController {

    @GetMapping("liveness")
    public String livenessProbe() {
        return "live";
    }

    @GetMapping("readiness")
    public String readinessProbe() {
        return "ready";
    }

    @GetMapping("startup")
    public String startupProbe() {
        return "startup";
    }
}
