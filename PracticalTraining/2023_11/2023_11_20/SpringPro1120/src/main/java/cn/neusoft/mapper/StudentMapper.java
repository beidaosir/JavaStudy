package cn.neusoft.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component  //相当于<bean id="studentMapper" class="cn.neusoft.mapper.StudentMapper">
@Repository  //数据处理层
public class StudentMapper {

    public void add(){
        System.out.println("mapper添加学生");
    }

}
