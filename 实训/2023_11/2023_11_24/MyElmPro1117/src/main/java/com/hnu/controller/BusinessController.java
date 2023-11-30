package com.hnu.controller;

import com.hnu.po.Business;
import com.hnu.query.BusinessQuery;
import com.hnu.service.BusinessService;
import com.hnu.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    BusinessService businessService;

    @RequestMapping("/add")
    public String add(Business business){
        boolean add = businessService.add(business);
        return add?"redirect:/business/list":"redirect:/businessAdd.jsp";
    }

    @RequestMapping("/update")
    public String update(Business business){
        boolean update = businessService.update(business);
        return update?"redirect:/business/list":"redirect:/business/findById/"+business.getBid();
    }

    @RequestMapping("/del/{id}")
    public String del(@PathVariable("id") Integer id){
        boolean del = businessService.del(id);
        return "redirect:/business/list";
    }

    @RequestMapping("/findById/{id}")
    public String findById(@PathVariable("id") Integer id, Model model){
        Business business = businessService.getById(id);
        model.addAttribute("business",business);
        return "businessUpdate";
    }

    @RequestMapping("/list")
    public String list(BusinessQuery businessQuery, Model model){
        PageBean<Business> pageBean = businessService.getByPage(businessQuery);
        model.addAttribute("pageBean",pageBean);
        return "businessList";
    }
}
