package com.akshay.springjdbc01;

import com.akshay.model.CourseJDBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJDBCRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_QUERY_HARD_CODED =
            """
                    insert into course (id, name, author)
                    values (1, 'Learn AWS', 'Akshay');
                    """;

    private static final String INSERT_QUERY = "insert into course (id, name, author) values (?, ?, ?)";
    private static final String DELETE_QUERY = "delete from course where id = ?";
    private static final String SELECT_BY_ID = "select * from course where id = ?";

    public void insertHardCodedData() {
        System.out.println("Running insert operation");
        jdbcTemplate.update(INSERT_QUERY_HARD_CODED);
    }

    public void insert(CourseJDBC course) {
        System.out.println("Running insert operation");
        jdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(long id) {
        System.out.println("Running delete operation");
        jdbcTemplate.update(DELETE_QUERY, id);
    }

    public CourseJDBC selectById(long id) {
        System.out.println("Running select operation");
        return jdbcTemplate.queryForObject(SELECT_BY_ID, new BeanPropertyRowMapper<>(CourseJDBC.class), id);
    }
}
