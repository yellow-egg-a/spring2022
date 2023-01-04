package com.fastcampus.programming.dmaker.controller;

import com.fastcampus.programming.dmaker.service.DMakerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DMakerController {
    private final DMakerService dMakerService;

    // Controller(Bean)에서 Service(Bean)를 사용하고 싶을 때, @RequiredArgsConstructor를 사용하여 주입한다.
    // DMakerController(Bean)     DMakerService(Bean)       DeveloperRepository(Bean)
    // =============================== Spring Application Context =========================


    @GetMapping("/developers")
    public List<String> getAllDevelopers() {
        // GET /developers HTTP/1.1
        log.info("// GET /developers HTTP/1.1");

        return Arrays.asList("snow", "Elsa", "Olaf");
    }

    @GetMapping("/create-developer")
    public List<String> createDevelopers() {
        // GET /developers HTTP/1.1
        log.info("// GET /create-developer HTTP/1.1");

        dMakerService.createDeveloper();

        return Collections.singletonList("Olaf");
    }
}
