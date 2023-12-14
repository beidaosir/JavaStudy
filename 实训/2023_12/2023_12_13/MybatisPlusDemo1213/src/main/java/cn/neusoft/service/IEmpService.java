package cn.neusoft.service;

import cn.neusoft.po.Emp;
import com.baomidou.mybatisplus.extension.service.IService;

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

}
