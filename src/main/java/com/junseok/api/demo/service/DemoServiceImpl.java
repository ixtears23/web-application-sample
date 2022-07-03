package com.junseok.api.demo.service;

import com.junseok.api.demo.domain.Demo;
import com.junseok.api.demo.domain.DemoMapper;
import com.junseok.api.demo.domain.DemoRepository;
import com.junseok.api.demo.vo.DemoRequest;
import com.junseok.api.demo.vo.DemoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@RequiredArgsConstructor
@Service
public class DemoServiceImpl implements DemoService {

    @Resource
    private DemoRepository demoRepository;
    private final DemoMapper demoMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public DemoResponse createDemo(DemoRequest demoRequest) {
        demoRepository.insertDemo(demoMapper.from(demoRequest));
        return DemoResponse.builder()
                .name(demoRequest.getName())
                .build();
    }

    @Transactional(readOnly = true)
    @Override
    public Demo getDemo(String name) {
        return demoRepository.findByName(name);
    }
}
