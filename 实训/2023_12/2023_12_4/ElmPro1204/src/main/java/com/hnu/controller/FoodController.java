package com.hnu.controller;

import com.hnu.po.Food;
import com.hnu.query.FoodQuery;
import com.hnu.service.FoodService;
import com.hnu.vo.ResponseObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    FoodService foodService;

    @PostMapping("/save")
    public ResponseObj save(@RequestBody Food food){
        boolean result = false;
        if (food.getFoodId()==null){
            result = foodService.add(food);
        }else{
            result = foodService.update(food);
        }
        return result?ResponseObj.SUCCESS():ResponseObj.ERROR();
    }

    @DeleteMapping("/{id}")
    public ResponseObj del(@PathVariable("id") Integer id){
        return foodService.del(id)?ResponseObj.SUCCESS():ResponseObj.ERROR();
    }

    @GetMapping("/{id}")
    public ResponseObj findById(@PathVariable("id") Integer id){
        return ResponseObj.SUCCESS(foodService.getById(id));
    }

    @PostMapping("/page")
    public ResponseObj page(@RequestBody FoodQuery businessQuery){
        return ResponseObj.SUCCESS(foodService.getByPage(businessQuery));
    }

    @PostMapping("/explain")
    public ResponseObj updateExplain(@RequestBody Food food){
        return foodService.updateExplain(food)?ResponseObj.SUCCESS():ResponseObj.ERROR();
    }

    @GetMapping("/explain/{id}")
    public ResponseObj getExplain(@PathVariable("id") Integer foodId){
        ResponseObj success = ResponseObj.SUCCESS();
        success.setData(foodService.getExplain(foodId));
        return success;
    }

}