package com.junseok.api.demo.controller;

import com.junseok.api.demo.domain.Demo;
import com.junseok.api.demo.service.DemoService;
import com.junseok.api.demo.vo.DemoRequest;
import com.junseok.api.demo.vo.DemoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/demo")
public class DemoController {

    private final DemoService demoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Demo getDemo(@ModelAttribute DemoRequest request) {
        return demoService.getDemo("name");
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public DemoResponse createDemo(@RequestBody @Valid DemoRequest request) {
        return demoService.createDemo(request);
    }

}
