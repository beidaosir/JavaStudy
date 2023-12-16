package cn.neusoft.controller;

import cn.neusoft.query.FoodQuery;
import cn.neusoft.service.IFoodService;
import cn.neusoft.vo.ResponseObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    IFoodService foodService;

    @PostMapping("/page")
    public ResponseObj page(@RequestBody FoodQuery foodQuery){
        return ResponseObj.SUCCESS(foodService.getByPage(foodQuery));
    }

}
