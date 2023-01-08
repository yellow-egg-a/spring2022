package com.fastcampus.programming.dmaker.controller;

import com.fastcampus.programming.dmaker.dto.CreateDeveloper;
import com.fastcampus.programming.dmaker.dto.DeveloperDetailDto;
import com.fastcampus.programming.dmaker.dto.DeveloperDto;
import com.fastcampus.programming.dmaker.service.DMakerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
    public List<DeveloperDto> getAllDevelopers() {
        // GET /developers HTTP/1.1
        log.info("// GET /developers HTTP/1.1");

        return dMakerService.getAllDevelopers();
    }

    @GetMapping("/developer/{memberId}")
    public DeveloperDetailDto getDeveloperDetail(
            @PathVariable String memberId
    ) {
        // GET /developers HTTP/1.1
        log.info("// GET /developers HTTP/1.1");

        return dMakerService.getDeveloperDetail(memberId);
    }

    @PostMapping("/create-developer")
    public CreateDeveloper.Response createDevelopers(
            @Valid @RequestBody CreateDeveloper.Request request )
    {
        log.info("request : {}", request);

        return dMakerService.createDeveloper(request);
    }
}
