package com.hnu.test;

import com.hnu.mapper.EmployeeMapper;
import com.hnu.po.Employee;
import com.hnu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class EmployeeMapperTest {

    /* 用来测试缓存
    *   mybatis中默认开启一级缓存  session级别的缓存  只要是同一次会话发起的相同查询sql只执行一次
    *   mybatis中还存在二级缓存  需要手动开启   SqlSessionFactory级别的缓存
    *    开启方式：
    *      总配置文件中进行配置
    *           <settings>
                    <setting name="cacheEnabled" value="true"/>
                </settings>
    *      映射配置文件加入   <cache/>
    *      涉及到的实体类实现序列化接口  implements Serializable
    * */
    @Test
    public void testGetByEmpno(){
        SqlSession session = MybatisUtil.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = mapper.getByEmpno(7654);
        System.out.println(employee);
        session.close();
        System.out.println("------------------------------------");
        SqlSession session1 = MybatisUtil.getSession();
        EmployeeMapper mapper1 = session1.getMapper(EmployeeMapper.class);
        Employee employee1 = mapper1.getByEmpno(7654);
        System.out.println(employee1);
        session1.close();
    }

}
