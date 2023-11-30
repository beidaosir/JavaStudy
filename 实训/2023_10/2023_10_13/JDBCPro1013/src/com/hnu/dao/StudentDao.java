package com.hnu.dao;


import com.hnu.bean.Student;

import java.util.List;

public interface StudentDao {

    public int save(Student student);
    public int update(Student student);
    public int remove(Integer id);
    public List<Student> getAll();
    public Student getById(Integer id);

}
