package cn.neusoft.controller;

import cn.neusoft.po.Food;
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

    @PostMapping("/save")
    public ResponseObj save(@RequestBody Food food){
        boolean b = foodService.saveOrUpdate(food);
        return b?ResponseObj.SUCCESS("保存餐品成功"):ResponseObj.ERROR(70001,"保存餐品失败");
    }

    @DeleteMapping("/{id}")
    public ResponseObj del(@PathVariable("id") Integer id){
        return foodService.removeById(id)?
                ResponseObj.SUCCESS("删除餐品成功"):ResponseObj.ERROR(70002,"删除餐品失败");
    }

    @GetMapping("/{id}")
    public ResponseObj findById(@PathVariable("id") Integer id){
        return ResponseObj.SUCCESS(foodService.getById(id));
    }

    @PostMapping("/page")
    public ResponseObj page(@RequestBody FoodQuery foodQuery){
        return ResponseObj.SUCCESS(foodService.getByPage(foodQuery));
    }

}
