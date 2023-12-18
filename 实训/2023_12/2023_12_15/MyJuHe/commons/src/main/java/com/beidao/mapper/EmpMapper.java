package com.beidao.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.beidao.po.Emp;



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

}
