package com.akshay.jpa02;

import com.akshay.model.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepository {

//    @Autowired - instead of this use this for entity manager
    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Course course) {
        entityManager.merge(course);
    }

    public Course findById(int id) {
        return entityManager.find(Course.class, id);
    }

    public void deleteById (int id) {
        Course course = findById(id);
        entityManager.remove(course);
    }

}
