package com.lewandowski.budget.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.lewandowski.budget.service" })
public class ServiceConfig {
}
