package com.my.springdata.dao;

import com.my.springdata.domain.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoSpringJdbcImpl implements StudentDao {

    private JdbcTemplate jdbcTemplate;

    /**
     * 查询所有学生的方法
     * @return
     */
    public List<Student> query() {
        final List<Student> studentList = new ArrayList<Student>();
        String sql = "select id, age, name from student";

        jdbcTemplate.query(sql, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                int id = resultSet.getInt("id");
                int age = resultSet.getInt("age");
                String name = resultSet.getString("age");

                Student student = new Student();
                student.setId(id);
                student.setAge(age);
                student.setName(name);

                studentList.add(student);
            }
        });

        return studentList;
    }

    /**
     * 添加学生
     * @param student
     */
    public void save(Student student) {
        String sql = "insert into student(name, age) values(?,?)";
        jdbcTemplate.update(sql, new Object[]{student.getName(), student.getAge()});
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
