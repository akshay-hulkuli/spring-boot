package com.akshay.jpa02;

import com.akshay.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJPACommandLineRunner implements CommandLineRunner {

    @Autowired
    CourseJpaRepository courseJpaRepository;

    @Override
    public void run(String... args) throws Exception {
//        courseJpaRepository.insert(new Course(2, "Learn Azure", "Kohli"));
//        courseJpaRepository.insert(new Course(3, "Learn React", "Saini"));
//        courseJpaRepository.insert(new Course(4, "Learn Redis", "Kohli"));
//        courseJpaRepository.deleteById(2);
//        System.out.println(courseJpaRepository.findById(3));
    }
}
