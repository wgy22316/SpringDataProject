package com.my.springdata.dao;

import com.my.springdata.domain.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class StudentDaoImplTest {

    private StudentDao studentDao;
    @Before
    public void setUp() throws Exception {
        studentDao = new StudentDaoImpl();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void query() {
        List<Student> studentList = studentDao.query();
        for (Student student : studentList){
            System.out.println("id:" + student.getId() + ", age:" + student.getAge() + ", name:" + student.getName());
        }
    }

    @Test
    public void testSave() {
        Student student = new Student();
        student.setAge(20);
        student.setName("test");

        studentDao.save(student);
    }
}