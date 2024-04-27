package com.akshay.springjdbc01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJDBCCommandLineRunner implements CommandLineRunner {

    @Autowired
    CourseJDBCRepository courseJDBCRepository;

    @Override
    public void run(String... args) throws Exception {
//        courseJDBCRepository.insertHardCodedData();
//        courseJDBCRepository.insert(new CourseJDBC(2, "Learn Azure", "Kohli"));
//        courseJDBCRepository.insert(new CourseJDBC(3, "Learn React", "Saini"));
//        courseJDBCRepository.insert(new CourseJDBC(4, "Learn Redis", "Kohli"));
//        courseJDBCRepository.deleteById(1);
//        System.out.println(courseJDBCRepository.selectById(3));
    }
}
