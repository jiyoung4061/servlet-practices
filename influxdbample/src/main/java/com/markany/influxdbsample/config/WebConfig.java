package com.markany.influxdbsample.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.markany.config.web.MvcConfig;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.markany.influxdbsample.controller"})
@Import({MvcConfig.class})
public class WebConfig {
	
}
