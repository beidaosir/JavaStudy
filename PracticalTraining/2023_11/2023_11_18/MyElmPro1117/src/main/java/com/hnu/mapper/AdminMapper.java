package com.hnu.mapper;

import com.hnu.po.Admin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface AdminMapper {

   @Select("SELECT adminId,adminName,`password`,role FROM t_admin WHERE adminName=#{adminName} AND `password`=#{password}")
   Admin getByCondition(@Param("adminName") String username, @Param("password") String password);

}