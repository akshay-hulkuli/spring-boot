package com.akshay.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/*
    Spring Boot helps in building Production Ready application Quickly
    Some of the noteworthy features are ->
        * Build quickly
            1. Spring Initializr
            2. Spring Boot Starter Projects
            3. Spring Boot Auto Configuration
            4. Spring Boot DevTools
        * Be Production Ready
            1. Logging
            2. Different Configuration for Different environments (Profiles)
            3. Monitoring (Actuators)
 */

@RestController
public class CourseController {

    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses() {
        return Arrays.asList(new Course(1, "Learn AWS", "Akshay"), new Course(2, "Learn GCP", "Shubman"));
    }
}
