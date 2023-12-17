package com.hnu.service;

import com.hnu.po.Emp;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
