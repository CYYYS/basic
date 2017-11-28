package com.example.cmd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.support.ServletRequestHandledEvent;




@SpringBootApplication
@EnableConfigurationProperties
public class BasicApplication {
	
	public static Logger log = LoggerFactory.getLogger(BasicApplication.class);

	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BasicApplication.class, args);
		//测试日志
		System.out.println("--------------------------------------");
		log.info("888");
		//测试使用配置文件为属性赋值
		Taiji taiji = (Taiji) context.getBean(Taiji.class);
		System.out.println(taiji);
	}
	@Autowired
	private CounterService counterService;

	
	@Bean
	
	public ApplicationListener<ApplicationEvent> xyzListener() {
		final String HELLO_URL = "/xyz";

		return (ApplicationEvent event) -> {
			if (event instanceof ServletRequestHandledEvent) {
				ServletRequestHandledEvent e = (ServletRequestHandledEvent) event;
				if (e.getRequestUrl().equals(HELLO_URL))
					counterService.increment("xyz.hits");
			}
		};
	}
}
