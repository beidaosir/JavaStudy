package cn.neusoft.controller;

import cn.neusoft.po.User;
import cn.neusoft.query.UserQuery;
import cn.neusoft.service.IUserService;
import cn.neusoft.util.GenerateUtils;
import cn.neusoft.vo.ResponseObj;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    //分页查询
   @PostMapping("/page")
   public ResponseObj getByPgae(UserQuery userQuery){
       Page<User> page = userService.getByPage(userQuery);
       return ResponseObj.SUCCESS(page);
   }

    //通过id查询
   @GetMapping("/{id}")
   public ResponseObj getById(@PathVariable("id") Integer userId){
       User user = userService.getById(userId);
       return ResponseObj.SUCCESS(user);
   }


}
