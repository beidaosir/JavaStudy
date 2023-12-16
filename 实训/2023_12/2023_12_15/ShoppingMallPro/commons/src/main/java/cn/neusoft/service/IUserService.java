package cn.neusoft.service;

import cn.neusoft.po.User;
import cn.neusoft.query.UserQuery;
import cn.neusoft.vo.ResponseObj;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IUserService extends IService<User> {

    User login(String username,String password);

    User getByPhone(String phone);

    Page<User> getByPage(UserQuery userQuery);
}
