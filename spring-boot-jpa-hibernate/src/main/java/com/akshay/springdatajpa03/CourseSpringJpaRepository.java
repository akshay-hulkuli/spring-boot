package com.akshay.springdatajpa03;

import com.akshay.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseSpringJpaRepository extends JpaRepository<Course, Long> {
    List<Course> findAllByAuthor(String author);
    List<String> findNamesByAuthor(String author);
}
