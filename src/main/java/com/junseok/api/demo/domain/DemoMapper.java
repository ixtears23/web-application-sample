package com.junseok.api.demo.domain;

import com.junseok.api.demo.vo.DemoRequest;
import org.springframework.stereotype.Component;

@Component
public class DemoMapper {
    public Demo from(DemoRequest demoRequest) {
        return Demo.builder()
                .name(demoRequest.getName())
                .build();
    }
}
