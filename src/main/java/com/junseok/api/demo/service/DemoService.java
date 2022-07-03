package com.junseok.api.demo.service;

import com.junseok.api.demo.domain.Demo;
import com.junseok.api.demo.vo.DemoRequest;
import com.junseok.api.demo.vo.DemoResponse;

public interface DemoService {
    DemoResponse createDemo(DemoRequest demoRequest);
    Demo getDemo(String name);
}
