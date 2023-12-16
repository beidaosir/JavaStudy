package cn.neusoft.service;

import cn.neusoft.po.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IAdminService extends IService<Admin> {

    Admin login(String username,String password);

}
