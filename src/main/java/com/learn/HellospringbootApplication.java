package com.learn;

import com.codahale.metrics.ConsoleReporter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;

import java.util.concurrent.TimeUnit;

@ServletComponentScan(basePackages = {"com.learn.filter"})
@SpringBootApplication
public class HellospringbootApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(HellospringbootApplication.class, args);
		//metrics-core测试
		/*ConsoleReporter reporter = ctx.getBean(ConsoleReporter.class);
		reporter.start(5, TimeUnit.SECONDS);*/
	}
}
