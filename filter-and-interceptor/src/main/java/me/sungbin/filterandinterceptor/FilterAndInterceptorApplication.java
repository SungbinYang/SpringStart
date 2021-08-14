package me.sungbin.filterandinterceptor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class FilterAndInterceptorApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilterAndInterceptorApplication.class, args);
    }

}
