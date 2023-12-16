package cn.neusoft.controller;

import cn.neusoft.po.Business;
import cn.neusoft.query.BusinessQuery;
import cn.neusoft.service.IBusinessService;
import cn.neusoft.vo.ResponseObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    IBusinessService businessService;

    /**
     * 添加或修改
     * @param business  添加或修改的实体对象
     * @return
     */
    @PostMapping("/save")
    public ResponseObj save(@RequestBody Business business){

        boolean b = businessService.saveOrUpdate(business);
        return b?ResponseObj.SUCCESS("保存商家成功"):ResponseObj.ERROR(50001,"保存商家失败");
    }

    @DeleteMapping("/{id}")
    public ResponseObj del(@PathVariable("id") Integer id){
        return businessService.removeById(id)
                ?ResponseObj.SUCCESS("删除商家成功"):ResponseObj.ERROR(50002,"删除商家失败");
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
        return businessService.checkAcount(account)?ResponseObj.ERROR(50003,"账号已经存在，不可使用"):ResponseObj.SUCCESS("账号可以使用");
    }

    @PostMapping("/batch")
    public ResponseObj delBatch(@RequestBody List<Integer> bids) throws Exception {
        return businessService.removeBatchByIds(bids)?
                ResponseObj.SUCCESS():
                ResponseObj.ERROR(500,"批量删除失败");
    }

    @PostMapping("/app/page")
    public ResponseObj appPage(@RequestBody BusinessQuery businessQuery){
        return ResponseObj.SUCCESS(businessService.getByPage(businessQuery));
    }
}
