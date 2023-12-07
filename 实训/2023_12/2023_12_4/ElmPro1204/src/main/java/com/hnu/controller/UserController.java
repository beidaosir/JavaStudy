package com.hnu.controller;

import com.hnu.po.User;
import com.hnu.query.UserQuery;
import com.hnu.service.UserService;
import com.hnu.vo.ResponseObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    //注册
    @PostMapping("/reg")
    public ResponseObj register(@RequestBody User user){
       return userService.register(user);
    }

    //修改
   @PostMapping("/update")
   public ResponseObj update(@RequestBody User user){
       return userService.update(user);
   }

    //注销
   @DeleteMapping("/unreg/{id}")
   public ResponseObj unRegister(@PathVariable("id") Integer userId){
        return userService.unRegister(userId);
   }

    //登录
   @PostMapping("/log")
   public ResponseObj login(@RequestBody User user){
        return userService.login(user);
   }

    //分页查询
   @PostMapping("/page")
   public ResponseObj getByPgae(UserQuery userQuery){
        return userService.getByPgae(userQuery);
   }

    //通过id查询
   @GetMapping("/{id}")
   public ResponseObj getById(@PathVariable("id") Integer userId){
        return userService.getById(userId);
   }

    //通过手机号和验证码登录
   @GetMapping("/log/{phone}/{code}")
   public ResponseObj loginByPhone(@PathVariable("phone") String phone,@PathVariable("code") String validCode){
        return userService.loginByPhone(phone,validCode);
   }

}
