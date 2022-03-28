package com.mclody.mrs.hosp.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.mclody.mrs.hosp.mapper")
public class HospConfig {
}
