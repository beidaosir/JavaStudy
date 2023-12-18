package com.beidao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.beidao.mapper.EmpMapper;
import com.beidao.po.Emp;
import com.beidao.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lee
 * @since 2023-12-17
 */
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements IEmpService {


}
