package com.beidao.module6.mapper;

import com.beidao.module6.dto.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper // @Mapper注解，将当前接口标记为Mapper接口
//实现类(mybatis和spring)，可以通过@Autowired注入
public interface StudentMapper {


    @Select("select id,name from student")
    List<Student> findAll();

    @Select("select id,name from student where id = #{id}")
    Student findById(Integer id);

    @Insert("insert into student(id,name) values(#{id},#{name})")
    void save(@Param("name") String name, @Param("id") Integer id);

    void update(Student student);

    void delete(Integer id);


}
