package cn.neusoft.service.impl;


import cn.neusoft.mapper.AdminMapper;
import cn.neusoft.po.Admin;
import cn.neusoft.service.IAdminService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class AdminService extends ServiceImpl<AdminMapper, Admin> implements IAdminService{

    @Override
    public Admin login(String username, String password) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username",username);
        queryWrapper.eq("password",password);
        Admin admin = baseMapper.selectOne(queryWrapper);
        return admin;
    }
}
