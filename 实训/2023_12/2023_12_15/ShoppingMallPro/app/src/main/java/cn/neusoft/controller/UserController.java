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

    //注册
    @PostMapping("/reg/{code}")
    public ResponseObj register(@RequestBody User user,@PathVariable("code") Integer code,HttpSession session){

        Object smsCode = session.getAttribute("smsCode");
        if (smsCode!=null && smsCode.equals(code)){
            boolean save = userService.updateById(user);
            return save?ResponseObj.SUCCESS(user):ResponseObj.ERROR(334,"注册失败");
        }

        return ResponseObj.ERROR(334,"注册失败");
    }

    //修改
   @PostMapping("/update")
   public ResponseObj update(@RequestBody User user){
       boolean b = userService.updateById(user);
       return b?ResponseObj.SUCCESS("修改员工信息成功"):ResponseObj.ERROR(70001,"修改员工信息失败");
   }

    //注销
   @DeleteMapping("/unreg/{id}")
   public ResponseObj unRegister(@PathVariable("id") Integer userId){
       boolean b = userService.removeById(userId);
       return b?ResponseObj.SUCCESS("注销成功"):ResponseObj.ERROR(70001,"注销失败");
   }

    //登录
   @PostMapping("/log")
   public ResponseObj login(@RequestBody User user){
       User loginUser = userService.login(user.getUsername(), user.getPassword());
       return ResponseObj.SUCCESS(loginUser);
   }

    //通过id查询
   @GetMapping("/{id}")
   public ResponseObj getById(@PathVariable("id") Integer userId){
       User user = userService.getById(userId);
       return ResponseObj.SUCCESS(user);
   }

    //通过手机号和验证码登录
   @GetMapping("/log/{phone}/{code}")
   public ResponseObj loginByPhone(@PathVariable("phone") String phone,@PathVariable("code") Integer validCode,HttpSession session){
       Object smsCode = session.getAttribute(phone);
       if (smsCode!=null && smsCode.equals(validCode)){
           User user = userService.getByPhone(phone);
           return ResponseObj.SUCCESS(user);
       }
       return ResponseObj.ERROR(333,"手机号登录失败");
   }

   @GetMapping("/sms/{phone}")
   public ResponseObj getSmsCode(@PathVariable("phone") String phone,HttpSession session){
       String code = GenerateUtils.generateNumberCode(6);
       session.setAttribute(phone,code);
       return ResponseObj.SUCCESS(code);
   }

}
