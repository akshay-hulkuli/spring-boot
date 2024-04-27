package com.akshay.springdatajpa03;

import com.akshay.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseSpringJPACommandLineRunner implements CommandLineRunner {

    @Autowired
    CourseSpringJpaRepository courseSpringJpaRepository;

    @Override
    public void run(String... args) throws Exception {
        courseSpringJpaRepository.save(new Course(2, "Learn Azure", "Kohli"));
        courseSpringJpaRepository.save(new Course(3, "Learn React", "Saini"));
        courseSpringJpaRepository.save(new Course(4, "Learn Redis", "Kohli"));
        courseSpringJpaRepository.deleteById(2L);
        System.out.println(courseSpringJpaRepository.findById(3L));
        System.out.println(courseSpringJpaRepository.findAll());
        System.out.println(courseSpringJpaRepository.count());
        System.out.println(courseSpringJpaRepository.findAllByAuthor("Saini"));
        System.out.println(courseSpringJpaRepository.findNamesByAuthor("Saini"));
    }
}
