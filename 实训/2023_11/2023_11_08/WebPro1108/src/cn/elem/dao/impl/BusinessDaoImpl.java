package cn.elem.dao.impl;

import cn.elem.bean.Business;
import cn.elem.dao.BusinessDao;
import cn.elem.query.PageQuery;
import cn.elem.util.JdbcUtils;
import cn.elem.vo.PageBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusinessDaoImpl implements BusinessDao {

    @Override
    public int add(Business business) {
        String sql = "INSERT INTO t_business\n" +
                "(businessAccount,`password`,businessName,businessAddress,businessExplain,startPrice,deliveryPrice,role)\n" +
                "VALUES(?,?,?,?,?,?,?,?)";

        Connection conn = JdbcUtils.getConn();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, business.getBusinessAccount());
            preparedStatement.setString(2, business.getPassword());
            preparedStatement.setString(3, business.getBusinessName());
            preparedStatement.setString(4, business.getBusinessAddress());
            preparedStatement.setString(5, business.getBusinessExplain());
            preparedStatement.setDouble(6, business.getstartPrice());
            preparedStatement.setDouble(7, business.getDeliveryPrice());
            preparedStatement.setString(8, business.getRole());

            return preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return 0;
    }

    @Override
    public int update(Business business) {
        String sql = "UPDATE t_business SET businessAccount=?,businessName=?,businessAddress=?,businessExplain=?,startPrice=?,deliveryPrice=?\n" +
                "WHERE bid=?";

        Connection conn = JdbcUtils.getConn();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, business.getBusinessAccount());
            preparedStatement.setString(2, business.getBusinessName());
            preparedStatement.setString(3, business.getBusinessAddress());
            preparedStatement.setString(4, business.getBusinessExplain());
            preparedStatement.setDouble(5, business.getstartPrice());
            preparedStatement.setDouble(6, business.getDeliveryPrice());
            preparedStatement.setInt(7, business.getBid());

            return preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return 0;
    }


    @Override
    public int remove(Integer bid) {
        String sql = "DELETE FROM t_business WHERE bid=?";

        Connection conn = JdbcUtils.getConn();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, bid);

            return preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return 0;
    }

    @Override
    public Business getById(Integer bid) {

        String sql = "SELECT bid,businessAccount,`password`,businessName,businessAddress,businessExplain,startPrice,deliveryPrice,role\n" +
                "FROM t_business WHERE bid=?";

        Connection conn = JdbcUtils.getConn();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, bid);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String businessAccount = resultSet.getString("businessAccount");
                String password = resultSet.getString("password");
                String businessName = resultSet.getString("businessName");
                String businessAddress = resultSet.getString("businessAddress");
                String businessExplain = resultSet.getString("businessExplain");
                double startPrice = resultSet.getDouble("startPrice");
                double deliveryPrice = resultSet.getDouble("deliveryPrice");
                String role = resultSet.getString("role");

                return new Business(bid, businessAccount, password, businessName,
                        businessAddress, businessExplain, startPrice, deliveryPrice, role);

            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Business> getAll() {
        List<Business> businessList = new ArrayList<>();

        String sql = "SELECT bid,businessAccount,`password`,businessName,businessAddress,businessExplain,startPrice,deliveryPrice,role\n" +
                "FROM t_business";

        Connection conn = JdbcUtils.getConn();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){

                int bid = resultSet.getInt("bid");
                String businessAccount = resultSet.getString("businessAccount");
                String password = resultSet.getString("password");
                String businessName = resultSet.getString("businessName");
                String businessAddress = resultSet.getString("businessAddress");
                String businessExplain = resultSet.getString("businessExplain");
                double startPrice = resultSet.getDouble("startPrice");
                double deliveryPrice = resultSet.getDouble("deliveryPrice");
                String role = resultSet.getString("role");

                Business business = new Business(bid,businessAccount,password,businessName,
                        businessAddress,businessExplain,startPrice,deliveryPrice,role);
                businessList.add(business);
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return businessList;
    }


    @Override
    public PageBean<Business> getByPage(PageQuery pageQuery) {
        PageBean<Business> pageBean= new PageBean<>();
        List<Business> businessList = new ArrayList<>();
        String sql = "SELECT bid,businessAccount,`password`,businessName,businessAddress,businessExplain,startPrice,deliveryPrice,role\n" +
                "FROM t_business LIMIT ?,?";

        Connection conn = JdbcUtils.getConn();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setInt(1,pageQuery.getStartIndex());
            preparedStatement.setInt(2,pageQuery.getPageNumber());

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){

                int bid = resultSet.getInt("bid");
                String businessAccount = resultSet.getString("businessAccount");
                String password = resultSet.getString("password");
                String businessName = resultSet.getString("businessName");
                String businessAddress = resultSet.getString("businessAddress");
                String businessExplain = resultSet.getString("businessExplain");
                double startPrice = resultSet.getDouble("startPrice");
                double deliveryPrice = resultSet.getDouble("deliveryPrice");
                String role = resultSet.getString("role");

                Business business = new Business(bid,businessAccount,password,businessName,
                        businessAddress,businessExplain,startPrice,deliveryPrice,role);
                businessList.add(business);
            }

            //集合数据全部装完了， 设置到pageBean中
            pageBean.setData(businessList);

            //查询总记录
            Integer count = getCount(conn);
            pageBean.setTotalRows(count);

            //计算总页数
            Integer totalPages = count % pageQuery.getPageNumber()==0?count/pageQuery.getPageNumber():count/pageQuery.getPageNumber()+1;

            pageBean.setTotalPages(totalPages);

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return pageBean;
    }

    @Override
    public Business getByAccount(String businessAccount) {

        String sql = "select bid,businessAccount,`password`,businessName,businessAddress,businessExplain,startPrice,deliveryPrice,role\n" +
                "from t_business where businessAccount=?";

        Connection conn = JdbcUtils.getConn();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,businessAccount);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                int bid = resultSet.getInt("bid");
                String password = resultSet.getString("password");
                String businessName = resultSet.getString("businessName");
                String businessAddress = resultSet.getString("businessAddress");
                String businessExplain = resultSet.getString("businessExplain");
                double startPrice = resultSet.getDouble("startPrice");
                double deliveryPrice = resultSet.getDouble("deliveryPrice");
                String role = resultSet.getString("role");

                return new Business(bid,businessAccount,password,businessName,
                        businessAddress,businessExplain,startPrice,deliveryPrice,role);

            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return null;
    }

    /*
    查询总记录的方法  这个方法无需单独调用  可以直接写在实现类中
     */
    private Integer getCount(Connection conn){
        String sql = "select count(bid) coun from t_business";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet resultSet = pstm.executeQuery();
            if (resultSet.next()){
                return resultSet.getInt("coun");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }

}
