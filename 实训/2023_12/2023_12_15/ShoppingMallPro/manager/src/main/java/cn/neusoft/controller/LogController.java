package cn.neusoft.controller;

import cn.neusoft.service.IAdminService;
import cn.neusoft.service.IBusinessService;
import cn.neusoft.vo.LogUser;
import cn.neusoft.vo.ResponseObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    IAdminService adminService;

    @Autowired
    IBusinessService businessService;

    @PostMapping("/in")
    public ResponseObj login(@RequestBody LogUser logUser, HttpSession session){
        System.out.println(logUser);
        //设置一个登录用户  可能是管理员 也可能是商家
        Object loginUser = null;
        //管理员登录
        if ("manager".equals(logUser.getRole())){
            loginUser = adminService.login(logUser.getUsername(), logUser.getPassword());
        }else if("business".equals(logUser.getRole())){
            loginUser = businessService.login(logUser.getUsername(), logUser.getPassword());
        }

        System.out.println("**********登录完成*************"+loginUser);

        if (loginUser == null){
            return ResponseObj.ERROR(501,"登录失败");
        }else{
            //存入session
            session.setAttribute("loginUser",loginUser);
            //传递给前端  响应的json数据
            return ResponseObj.SUCCESS(loginUser);
        }
    }

    @GetMapping("/out")
    public ResponseObj logout(HttpSession session){
        session.removeAttribute("loginUser");
        return ResponseObj.SUCCESS();
    }
}
