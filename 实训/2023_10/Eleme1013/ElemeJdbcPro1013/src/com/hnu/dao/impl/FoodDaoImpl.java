package com.hnu.dao.impl;

import com.hnu.bean.Food;
import com.hnu.dao.FoodDao;
import com.hnu.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodDaoImpl implements FoodDao {
    @Override
    public List<Food> listFoodByBusinessId(Integer businessId) {

        List<Food> foodList = new ArrayList<>();

        String sql = "SELECT foodId,foodName,foodExplain,foodPrice,businessId FROM t_food WHERE businessId=?";

        //1、获取连接
        Connection conn = JDBCUtils.getConn();

        //2、获取预处理对象
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            //3、给？设置值
            preparedStatement.setInt(1, businessId);
            //4、执行查询 返回结果集
            ResultSet resultSet = preparedStatement.executeQuery();
            //5、处理结果集
            while (resultSet.next()) {
                //获取每一行的数据
                int foodId = resultSet.getInt("foodId");
                String foodName = resultSet.getString("foodName");
                String foodExplain = resultSet.getString("foodExplain");
                double foodPrice = resultSet.getDouble("foodPrice");

                //构建实体对象并返回
                Food food = new Food(foodId, foodName, foodExplain, foodPrice, businessId);
                //加入到集合
                foodList.add(food);
            }

            return foodList;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public Food getFoodById(Integer foodId) {
        String sql = "SELECT foodId,foodName,foodExplain,foodPrice,businessId FROM t_food WHERE foodId=?";

        //1、获取连接
        Connection conn = JDBCUtils.getConn();

        //2、获取预处理对象
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            //3、给？设置值
            preparedStatement.setInt(1, foodId);
            //4、执行查询 返回结果集
            ResultSet resultSet = preparedStatement.executeQuery();
            //5、处理结果集
            if (resultSet.next()) {
                //获取每一行的数据
                String foodName = resultSet.getString("foodName");
                String foodExplain = resultSet.getString("foodExplain");
                double foodPrice = resultSet.getDouble("foodPrice");
                int businessId = resultSet.getInt("businessId");

                //构建实体对象并返回
                return new Food(foodId, foodName, foodExplain, foodPrice, businessId);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    /*

     */
    @Override
    public boolean saveFood(Food food) {

        String sql = "INSERT INTO t_food(foodName,foodExplain,foodPrice,businessId) VALUES(?,?,?,?);";

        //1、获取连接
        Connection conn = JDBCUtils.getConn();

        //2、获取预处理对象
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            //3、给？设置值
            preparedStatement.setString(1, food.getFoodName());
            preparedStatement.setString(2, food.getFoodExplain());
            preparedStatement.setDouble(3, food.getFoodPrice());
            preparedStatement.setInt(4, food.getBusinessId());

            //4、执行sql
            int i = preparedStatement.executeUpdate();

            //5、判断并返回
            return i > 0;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updateFood(Food food) {

        String sql = "UPDATE t_food SET foodName=?,foodExplain=?,foodPrice=? WHERE foodId=?";

        //1、获取连接
        Connection conn = JDBCUtils.getConn();

        //2、获取预处理对象
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            //3、给？设置值
            preparedStatement.setString(1, food.getFoodName());
            preparedStatement.setString(2, food.getFoodExplain());
            preparedStatement.setDouble(3, food.getFoodPrice());
            preparedStatement.setInt(4, food.getFoodId());

            //4、执行sql
            int i = preparedStatement.executeUpdate();

            //5、判断并返回
            return i > 0;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean removeFood(Integer foodId) {

        String sql = "DELETE FROM t_food WHERE foodId=?";

        //1、获取连接
        Connection conn = JDBCUtils.getConn();

        //2、获取预处理对象
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            //3、给？设置值
            preparedStatement.setInt(1, foodId);

            //4、执行sql
            int i = preparedStatement.executeUpdate();

            //5、判断并返回
            return i > 0;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return false;
    }
}
