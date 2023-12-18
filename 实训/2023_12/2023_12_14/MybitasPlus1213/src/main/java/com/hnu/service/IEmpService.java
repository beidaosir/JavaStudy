package com.hnu.service;

import com.hnu.po.Emp;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hnu.vo.DeptEmpNumber;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lee
 * @since 2023-12-17
 */
public interface IEmpService extends IService<Emp> {

    Emp getById(Integer empno);

    List<DeptEmpNumber> getCountByDept();
}
