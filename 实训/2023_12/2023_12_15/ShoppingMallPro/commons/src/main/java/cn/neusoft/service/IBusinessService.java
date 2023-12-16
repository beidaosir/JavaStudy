package cn.neusoft.service;

import cn.neusoft.po.Business;
import cn.neusoft.query.BusinessQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IBusinessService extends IService<Business> {

    Business login(String username,String password);

    Page<Business> getByPage(BusinessQuery businessQuery);

    boolean checkAcount(String account);
}
