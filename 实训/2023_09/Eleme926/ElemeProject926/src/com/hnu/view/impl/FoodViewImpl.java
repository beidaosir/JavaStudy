package com.hnu.view.impl;

import com.hnu.bean.Food;
import com.hnu.service.FoodService;
import com.hnu.service.impl.FoodServiceImpl;
import com.hnu.view.FoodView;

import java.util.List;
import java.util.Scanner;

public class FoodViewImpl implements FoodView {


    FoodService foodService = new FoodServiceImpl();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void listFoodByBusinessId(Integer businessId) {

        List<Food> foods = foodService.listFoodByBusinessId(businessId);
        //查不到的情况
        if (foods==null || foods.size()==0){

            System.out.println("贵餐厅尚未添加餐品，请添加之后再查询");
            return;
        }
        System.out.println("餐品编号\t\t餐品名称\t餐品价格\t餐品介绍");
        for (Food food:foods) {
            System.out.println(food.getFoodId()+"\t" + food.getFoodName()+"\t"+ food.getFoodPrice()+"\t"+
                    food.getFoodExplain()+"\t");
        }
    }

    @Override
    public void saveFood(Integer businessId) {

        System.out.println("请输入餐品名称：");
        String foodName = scanner.next();
        System.out.println("请输入餐品介绍：");
        String foodExplain= scanner.next();
        System.out.println("请输入餐品价格：");
        double foodPrice = scanner.nextDouble();

        Food food = new Food();
        food.setBusinessId(businessId);
        food.setFoodName(foodName);
        food.setFoodExplain(foodExplain);
        food.setFoodPrice(foodPrice);

        boolean b = foodService.saveFood(food);
        System.out.println("添加餐品"+(b?"成功":"失败"));

    }

    @Override
    public void updateFood(Integer businessId) {

        System.out.println("请输入餐品编号：");
        int foodId = scanner.nextInt();

        Food food = foodService.getFoodById(foodId);
        if (food == null){
            System.out.println("抱歉，您的编号有误，请重新输入！");
            return;
        }

        if (!food.getBusinessId().equals(businessId)){
            System.out.println("您输入的餐品不是本餐厅的，禁止修改！");
            return;
        }

        //可以修改了
        System.out.println("您要修改餐品名称吗？(y/n)");
        String inputStr = scanner.next();
        if ("y".equals(inputStr)){
            System.out.println("请输入新的餐品名称：");
            food.setFoodName(scanner.next());
        }

        System.out.println("您要修改餐品介绍吗？(y/n)");
        inputStr = scanner.next();
        if ("y".equals(inputStr)){
            System.out.println("请输入新的餐品介绍：");
            food.setFoodExplain(scanner.next());
        }

        System.out.println("您要修改餐品价格吗？(y/n)");
        inputStr = scanner.next();
        if ("y".equals(inputStr)){
            System.out.println("请输入新的餐品价格：");
            food.setFoodPrice(scanner.nextDouble());
        }

        System.out.println("您确定要修改吗？(y/n)");
        inputStr = scanner.next();
        if ("y".equals(inputStr)){
            boolean b = foodService.updateFood(food);
            System.out.println("修改餐品"+(b?"成功":"失败"));
            return;
        }
        System.out.println("您取消了修改！");

    }

    @Override
    public void removeFood(Integer businessId) {
        System.out.println("请输入要删除的餐品编号");
        int foodId = scanner.nextInt();

        Food food = foodService.getFoodById(foodId);
        if (food == null) {
            System.out.println("抱歉，您的编号有误，该餐品不存在，请重新输入!");
            return;
        }

        if (!food.getBusinessId().equals(businessId)) {
            System.out.println("您输入的餐品不是本餐厅的，禁止删除！");
            return;
        }

        System.out.println("您确定要修改吗？(y/n)");
        String inputStr = scanner.next();
        if ("y".equals(inputStr)) {
            //可以删除了
            boolean b = foodService.removeFood(foodId);
            System.out.println("删除餐品" + (b ? "成功" : "失败"));
            return;
        }
        System.out.println("您取消了删除！");
    }
}
