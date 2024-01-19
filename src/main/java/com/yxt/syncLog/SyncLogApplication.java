package com.yxt.syncLog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SyncLogApplication {

	public static void main(String[] args) {
		SpringApplication.run(SyncLogApplication.class, args);
	}

}
