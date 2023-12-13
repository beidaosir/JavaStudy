package cn.neusoft.service.impl;

import cn.neusoft.exception.AppException;
import cn.neusoft.exception.AppExceptionCodeMsg;
import cn.neusoft.mapper.EmployeeMapper;
import cn.neusoft.po.Employee;
import cn.neusoft.query.EmployeeQuery;
import cn.neusoft.service.IEmployeeService;
import cn.neusoft.vo.PageBean;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class EmployeeService implements IEmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Transactional
    @Override
    public boolean add(Employee employee) {

        if (employee==null){
            throw new AppException(AppExceptionCodeMsg.REQUEST_PARAM_EMPTY);
        }

        if (employee.getEname()==null || "".equals(employee.getEname())){
            throw new AppException(AppExceptionCodeMsg.REQUEST_PARAM_EMPTY);
        }

        int add = employeeMapper.add(employee);

        return add>0;
    }

    @Transactional
    @Override
    public boolean update(Employee employee) {
        if (employee==null){
            throw new AppException(AppExceptionCodeMsg.REQUEST_PARAM_EMPTY);
        }

        if (employee.getEmpno()==null){
            throw new AppException(AppExceptionCodeMsg.REQUEST_PARAM_EMPTY);
        }

        if (employee.getEname()==null || "".equals(employee.getEname())){
            throw new AppException(AppExceptionCodeMsg.REQUEST_PARAM_EMPTY);
        }

        int update = employeeMapper.update(employee);

        return update>0;
    }

    @Transactional
    @Override
    public boolean del(Integer empno) {

        if (empno==null){
            throw new AppException(AppExceptionCodeMsg.REQUEST_PARAM_EMPTY);
        }

        int del = employeeMapper.del(empno);

        return del>0;
    }

    @Override
    public Employee getById(Integer empno) {

        if (empno==null){
            throw new AppException(AppExceptionCodeMsg.REQUEST_PARAM_EMPTY);
        }

        return employeeMapper.getById(empno);
    }

    @Override
    public PageBean<Employee> getByPage(EmployeeQuery query) {

        if (query==null){
            throw new AppException(AppExceptionCodeMsg.REQUEST_PARAM_EMPTY);
        }

        if (query.getPageNow()==null || query.getPageNow()<=0){
            query.setPageNow(1);
        }

        if (query.getPageSize()==null || query.getPageSize()<3){
            query.setPageSize(3);
        }

        PageBean<Employee> pageBean = new PageBean<>();

        Page<Employee> page = PageHelper.startPage(query.getPageNow(), query.getPageSize());

        employeeMapper.getByCondition(query);

        pageBean.setTotalRows((int)page.getTotal());
        pageBean.setTotalPages(page.getPages());
        pageBean.setData(page.getResult());

        return pageBean;
    }
}
