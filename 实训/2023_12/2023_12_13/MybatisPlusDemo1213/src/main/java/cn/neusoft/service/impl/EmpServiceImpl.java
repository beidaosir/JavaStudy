package cn.neusoft.service.impl;

import cn.neusoft.po.Emp;
import cn.neusoft.mapper.EmpMapper;
import cn.neusoft.service.IEmpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hxj
 * @since 2023-12-13
 */
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements IEmpService {

    @Autowired
    EmpMapper empMapper;

    @Override
    public Emp getById(Integer empno) {
        return empMapper.getById(empno);
    }
}
