package com.hnu.controller;

import com.hnu.po.Business;
import com.hnu.query.BusinessQuery;
import com.hnu.service.BusinessService;
import com.hnu.vo.ResponseObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    BusinessService businessService;

    /**
     * 添加或修改
     * @param business  添加或修改的实体对象
     * @return
     */
    @PostMapping("/save")
    public ResponseObj save(@RequestBody Business business){
        boolean result = false;
        if (business.getBid()==null){
            result = businessService.add(business);
        }else{
            result = businessService.update(business);
        }
        return result?ResponseObj.SUCCESS():ResponseObj.ERROR();
    }

    @DeleteMapping("/{id}")
    public ResponseObj del(@PathVariable("id") Integer id){
        return businessService.del(id)?ResponseObj.SUCCESS():ResponseObj.ERROR();
    }

    @GetMapping("/{id}")
    public ResponseObj findById(@PathVariable("id") Integer id){
        return ResponseObj.SUCCESS(businessService.getById(id));
    }

    @PostMapping("/page")
    public ResponseObj page(@RequestBody BusinessQuery businessQuery){
        return ResponseObj.SUCCESS(businessService.getByPage(businessQuery));
    }

    @GetMapping("/check/{account}")
    public ResponseObj checkAcount(@PathVariable("account") String account){
        return businessService.checkAcount(account)?ResponseObj.SUCCESS("canuse"):ResponseObj.ERROR(500,"cannotuse");
    }

    @PostMapping("/batch")
    public ResponseObj delBatch(@RequestBody Integer[] bids) throws Exception {
        return businessService.delBatch(bids)?ResponseObj.SUCCESS():ResponseObj.ERROR(500,"批量删除失败");
    }
}
