package com.oss.beellage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.oss.beellage.issue.domain", "com.oss.beellage.calendar.domain",
        "com.oss.beellage.schedule.domain"})
public class BeellageApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeellageApplication.class, args);
    }

}
