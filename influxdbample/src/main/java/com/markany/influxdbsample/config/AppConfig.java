package com.markany.influxdbsample.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.markany.config.app.InfluxDBConfiguration;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.markany.influxdbsample.service"})
@Import({InfluxDBConfiguration.class})
public class AppConfig {
	
}
	