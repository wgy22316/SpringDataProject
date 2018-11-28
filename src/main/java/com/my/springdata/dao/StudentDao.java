package com.my.springdata.dao;

import com.my.springdata.domain.Student;

import java.util.List;

public interface StudentDao {
    /**
     * 查询所有学生的方法
     * @return
     */
    public List<Student> query();

    /**
     * 添加学生的方法
     * @param student
     */
    public void save(Student student);
}
