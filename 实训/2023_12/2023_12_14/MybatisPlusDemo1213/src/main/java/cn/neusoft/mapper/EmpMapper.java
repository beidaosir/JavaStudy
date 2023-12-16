package cn.neusoft.mapper;

import cn.neusoft.po.Emp;
import cn.neusoft.vo.DeptEmpNumber;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hxj
 * @since 2023-12-13
 */
public interface EmpMapper extends BaseMapper<Emp> {

    /**
     * 根据指定的员工编号查询对应的员工信息和员工所在的部门信息
     * @param empno
     * @return
     */
    Emp getById(Integer empno);

    /**
     * 统计每个部门的人数
     */
    List<DeptEmpNumber> getCountByDept();

}
