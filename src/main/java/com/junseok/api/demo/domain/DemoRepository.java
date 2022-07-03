package com.junseok.api.demo.domain;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DemoRepository {
    int insertDemo(Demo demo);
    Demo findByName(@Param("name") String name);
}
