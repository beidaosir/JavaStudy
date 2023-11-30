package com.hnu.controller;

import com.hnu.po.Business;
import com.hnu.po.Food;
import com.hnu.query.FoodQuery;
import com.hnu.service.FoodService;
import com.hnu.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/food")
public class FoodController {

    @Autowired
    FoodService foodService;

    @RequestMapping("/add")
    public String add(Food food){
        boolean add = foodService.add(food);
        return add?"redirect:/food/list":"redirect:/foodAdd.jsp";
    }

    @RequestMapping("/update")
    public String update(Food food){
        boolean update = foodService.update(food);
        return update?"redirect:/food/list":"redirect:/food/findById/"+food.getFoodId();
    }

    @RequestMapping("/del/{id}")
    public String del(@PathVariable("id") Integer id){
        boolean del = foodService.del(id);
        return "redirect:/food/list";
    }

    @RequestMapping("/findById/{id}")
    public String findById(@PathVariable("id") Integer id, Model model){
        Food food = foodService.getById(id);
        model.addAttribute("food",food);
        return "foodUpdate";
    }

    @RequestMapping("/list")
    public String list(FoodQuery foodQuery, HttpSession session, Model model){

        //如果是商家  那么查询的条件中需要增加一个商家id
        Integer bid = null;
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser instanceof Business){
            Business business = (Business)loginUser;
            bid = business.getBid();
        }
        foodQuery.setBusinessId(bid);

        PageBean<Food> pageBean = foodService.getByPage(foodQuery);
        model.addAttribute("pageBean",pageBean);
        return "foodList";
    }
    
}
