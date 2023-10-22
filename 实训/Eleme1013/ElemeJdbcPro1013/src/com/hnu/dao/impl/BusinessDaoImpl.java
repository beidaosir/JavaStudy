package com.hnu.dao.impl;

import com.hnu.bean.Business;
import com.hnu.dao.BusinessDao;
import com.hnu.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusinessDaoImpl implements BusinessDao {
    @Override
    public List<Business> listBusiness(String businessNameCondition, String businessAddressCondition) {

        List<Business> businessList = new ArrayList<>();

        String sql = "select * from t_business where businessName like concat('%',?,'%') and businessAddress like concat('%',?,'%')";

        //1.获取连接
        Connection conn = JDBCUtils.getConn();
        //2.获取预处理对象
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            //3.给 ？ 设置值
            preparedStatement.setString(1,businessNameCondition);
            preparedStatement.setString(2,businessAddressCondition);
            //4、执行查询 返回结果集
            ResultSet resultSet = preparedStatement.executeQuery();

            //5.处理结果集
            while (resultSet.next()){

                //获取每一行的数据
                int businessId = resultSet.getInt("businessId");
                String businessName = resultSet.getString("businessName");
                String businessAddress = resultSet.getString("businessAddress");
                String businessExplain = resultSet.getString("businessExplain");
                double starPrice = resultSet.getDouble("starPrice");
                double deliveryPrice = resultSet.getDouble("deliveryPrice");

                //构建实体对象
                Business business = new Business(businessId,null,businessName,businessAddress,businessExplain,starPrice,deliveryPrice);

                //加入集合
                businessList.add(business);

            }
            //返回集合
            return businessList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Business getBusinessById(Integer businessId) {

        String sql = "SELECT * FROM t_business WHERE businessId=?";

        //1、获取连接
        Connection conn = JDBCUtils.getConn();

        //2、获取预处理对象
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            //3、给？设置值
            preparedStatement.setInt(1,businessId);
            //4、执行查询 返回结果集
            ResultSet resultSet = preparedStatement.executeQuery();
            //5、处理结果集
            if (resultSet.next()){
                //获取每一行的数据
                String businessName = resultSet.getString("businessName");
                String businessAddress = resultSet.getString("businessAddress");
                String businessExplain = resultSet.getString("businessExplain");
                double starPrice = resultSet.getDouble("starPrice");
                double deliveryPrice = resultSet.getDouble("deliveryPrice");

                //构建实体对象并返回
                return new Business(businessId,null,businessName,businessAddress,businessExplain,starPrice,deliveryPrice);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return null;
    }


    @Override
    public List<Business> listBusiness() {
        return null;
    }

    @Override
    public boolean saveBusiness(String businessName) {

        String sql = "insert into t_business(password,businessName,businessAddress,businessExplain,starPrice,deliveryPrice) values(?,?,?,?,?,?)";
        //1.获取连接
        Connection conn = JDBCUtils.getConn();
        //2.获取预处理对象
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            //3.给 ？ 设置值
            preparedStatement.setString(1,"111111");
            preparedStatement.setString(2,businessName);
            preparedStatement.setString(3,"");
            preparedStatement.setString(4,"");
            preparedStatement.setDouble(5,0.0);
            preparedStatement.setDouble(6,0.0);

            //4.执行sql
            int i = preparedStatement.executeUpdate();

            //5.判断并且返回
            return i>0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean removeBusiness(int businessId) {

        String sql = "delete from t_business where businessId = ?";
        //1.获取连接
        Connection conn = JDBCUtils.getConn();
        //2.获取预处理对象
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            //3.给 ？ 设置值
           preparedStatement.setInt(1,businessId);

            //4.执行sql
            int i = preparedStatement.executeUpdate();

            //5.判断并且返回
            return i>0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



    @Override
    public boolean updateBusiness(Business business) {


        String sql = "update t_business set businessName = ?,businessAddress = ?," +
                "businessExplain=?,starPrice=?,deliveryPrice=? where businessId = ?";
        //1.获取连接
        Connection conn = JDBCUtils.getConn();
        //2.获取预处理对象
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            //3.给 ？ 设置值
            preparedStatement.setString(1, business.getBusinessName());
            preparedStatement.setString(2, business.getBusinessAddress());
            preparedStatement.setString(3, business.getBusinessExplain());
            preparedStatement.setDouble(4,business.getStarPrice());
            preparedStatement.setDouble(5,business.getDeliveryPrice());
            preparedStatement.setInt(6,business.getBusinessId());

            //4.执行sql
            int i = preparedStatement.executeUpdate();

            //5.判断并且返回
            return i>0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean updateBusinessByPassword(Integer businessId, String password) {

        String sql = "UPDATE t_business SET `password`=? WHERE businessId=?";

        //1、获取连接
        Connection conn = JDBCUtils.getConn();

        //2、获取预处理对象
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            //3、给？设置值
            preparedStatement.setString(1, password);
            preparedStatement.setInt(2, businessId);

            //4、执行sql
            int i = preparedStatement.executeUpdate();

            //5、判断并返回
            return i>0;
        }catch (SQLException exception){
            exception.printStackTrace();
        }


        return false;

    }

    @Override
    public Business login(Integer businessId, String password) {

        String sql = "SELECT * FROM t_business WHERE businessId=? AND `password`=?";

        //1、获取连接
        Connection conn = JDBCUtils.getConn();

        //2、获取预处理对象
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            //3、给？设置值
            preparedStatement.setInt(1,businessId);
            preparedStatement.setString(2,password);
            //4、执行查询 返回结果集
            ResultSet resultSet = preparedStatement.executeQuery();
            //5、处理结果集
            if (resultSet.next()){
                //获取每一行的数据
                String pass = resultSet.getString("password");
                String businessName = resultSet.getString("businessName");
                String businessAddress = resultSet.getString("businessAddress");
                String businessExplain = resultSet.getString("businessExplain");
                double starPrice = resultSet.getDouble("starPrice");
                double deliveryPrice = resultSet.getDouble("deliveryPrice");

                //构建实体对象并返回
                return new Business(businessId,pass,businessName,businessAddress,businessExplain,starPrice,deliveryPrice);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }
}
