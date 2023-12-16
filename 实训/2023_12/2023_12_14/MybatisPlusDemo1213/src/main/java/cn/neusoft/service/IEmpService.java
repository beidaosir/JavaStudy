package cn.neusoft.service;

import cn.neusoft.po.Emp;
import cn.neusoft.vo.DeptEmpNumber;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hxj
 * @since 2023-12-13
 */
public interface IEmpService extends IService<Emp> {

    Emp getById(Integer empno);

    List<DeptEmpNumber> getCountByDept();

}
