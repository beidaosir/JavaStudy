package com.beidao.mapper;

import com.beidao.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    //根据id删除数据
    @Delete("delete from emp where id = #{id}")
    //public void delete(Integer id);
    public int delete(Integer id);

    //会自动将生成的主键值，赋值给emp对象的id属性
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    public void insert(Emp emp);


    @Update("update emp set username=#{username}, name=#{name}, gender=#{gender}, image=#{image}, job=#{job}, entrydate=#{entrydate}, dept_id=#{deptId}, update_time=#{updateTime} where id=#{id}")
    public void update(Emp emp);

    //根据id查询
    /*@Select("select id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time from emp where id=#{id}")
    public Emp getById(Integer id);*/


    //方案一：*起别名*：在SQL语句中，对不一样的列名起别名，别名和实体类属性名一样
    /*@Select("select id, username, password, name, gender, image, job, entrydate, " +
            "dept_id AS deptId, create_time AS createTime, update_time AS updateTime " +
            "from emp " +
            "where id=#{id}")
    public Emp getById(Integer id);
*/

    //方案二：**手动结果映射**：通过 @Results及@Result 进行手动结果映射
    @Results({
            @Result(column = "dept_id", property = "deptId"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    @Select("select id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time from emp where id=#{id}")
    public Emp getById(Integer id);



    //条件查询
    //方法一：
    /*@Select("select * from emp " +
            "where name like '%${name}%' " +
            "and gender = #{gender} " +
            "and entrydate between #{begin} and #{end} " +
            "order by update_time desc")
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);
*/
    //方法二:
   /* @Select("select * from emp " +
            "where name like concat('%',#{name},'%') " +
            "and gender = #{gender} " +
            "and entrydate between #{begin} and #{end} " +
            "order by update_time desc")
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);
*/

    //动态条件查询
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);


    //动态更新员工
    public void update2(Emp emp);


    //批量删除
    public void deleteByIds(List<Integer> ids);

}


