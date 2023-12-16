package cn.neusoft.controller;

import cn.neusoft.query.BusinessQuery;
import cn.neusoft.service.IBusinessService;
import cn.neusoft.vo.ResponseObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    IBusinessService businessService;

    @PostMapping("/page")
    public ResponseObj appPage(@RequestBody BusinessQuery businessQuery){
        return ResponseObj.SUCCESS(businessService.getByPage(businessQuery));
    }
}
