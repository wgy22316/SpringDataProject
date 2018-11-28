package com.my.springdata.dao;

import com.my.springdata.domain.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class StudentDaoSpringJdbcImplTest {

    private ApplicationContext applicationContext;
    private StudentDao studentDao;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        studentDao = (StudentDao) applicationContext.getBean("studentDao");
        System.out.println("setUp");
    }

    @After
    public void tearDown() throws Exception {
        applicationContext = null;
        System.out.println("tearDown");
    }

    @Test
    public void query() {
        List<Student> studentList = studentDao.query();
        for (Student student : studentList){
            System.out.println("id:" + student.getId() + ", age:" + student.getAge() + ", name:" + student.getName());
        }
    }

    @Test
    public void save() {
        Student student = new Student();
        student.setAge(30);
        student.setName("test");

        studentDao.save(student);
    }
}