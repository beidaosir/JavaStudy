package com.hnu.mapper;

import com.hnu.po.Emp;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hnu.vo.DeptEmpNumber;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lee
 * @since 2023-12-17
 */
public interface EmpMapper extends BaseMapper<Emp> {

    //根据指定的员工编号查询对应的员工信息和员工所在的部门信息

    Emp getById(Integer empno);

    List<DeptEmpNumber> getCountByDept();

}
