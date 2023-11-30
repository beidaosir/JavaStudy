package cn.elem.dao;

import cn.elem.bean.Admin;

public interface AdminDao {

    Admin getByName(String adminName);

}
