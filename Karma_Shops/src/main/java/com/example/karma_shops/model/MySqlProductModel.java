package com.example.karma_shops.model;

import com.example.karma_shops.entity.Category;
import com.example.karma_shops.entity.Product;
import com.example.karma_shops.entity.myenum.CategoryStatus;
import com.example.karma_shops.entity.myenum.ProductStatus;
import com.example.karma_shops.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class MySqlProductModel implements  ProductModel{

    @Override
    public Product create(Product obj) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "insert into product " +
                    "(categoryId, name,description,detail,thumbnail,price,qty, createdAt, updatedAt, status) " +
                    "values " +
                    "(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, obj.getCategoryId());
            preparedStatement.setString(2, obj.getName());
            preparedStatement.setString(3, obj.getDescription());
            preparedStatement.setString(4, obj.getDetail());
            preparedStatement.setString(5, obj.getThumbnail());
            preparedStatement.setDouble(6, obj.getPrice());
            preparedStatement.setInt(7, obj.getQty());
            preparedStatement.setString(8, obj.getCreatedAt().toString());
            preparedStatement.setString(9, obj.getUpdatedAt().toString());
            preparedStatement.setInt(10, obj.getStatus().getValue());
            System.out.println("Connection success!");
            preparedStatement.execute();
            return obj;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> findAll() {
        List<Product> list = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from product where status = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, CategoryStatus.ACTIVE.getValue());
            System.out.println("Connection success!");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                int categoryId = resultSet.getInt("categoryId");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                String detail = resultSet.getString("detail");
                String thumbnail = resultSet.getString("thumbnail");
                double price = resultSet.getDouble("price");
                int qty = resultSet.getInt("qty");
                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int intStatus= resultSet.getInt("status");
                Product obj = new Product();
                obj.setId(id);
                obj.setCategoryId(categoryId);
                obj.setName(name);
                obj.setDescription(description);
                obj.setDetail(detail);
                obj.setThumbnail(thumbnail);
                obj.setPrice(price);
                obj.setQty(qty);
                obj.setCreatedAt(createdAt);
                obj.setUpdatedAt(updatedAt);
                obj.setStatus(ProductStatus.of(intStatus));
                list.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Product findById(int id) {
        Product obj = null;
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from product where status = ? and id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, CategoryStatus.ACTIVE.getValue());
            preparedStatement.setInt(2, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                int categoryId = resultSet.getInt("categoryId");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                String detail = resultSet.getString("detail");
                String thumbnail = resultSet.getString("thumbnail");
                double price = resultSet.getDouble("price");
                int qty = resultSet.getInt("qty");
                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int intStatus= resultSet.getInt("status");
                obj = new Product();
                obj.setId(id);
                obj.setCategoryId(categoryId);
                obj.setName(name);
                obj.setDescription(description);
                obj.setDetail(detail);
                obj.setThumbnail(thumbnail);
                obj.setPrice(price);
                obj.setQty(qty);
                obj.setCreatedAt(createdAt);
                obj.setUpdatedAt(updatedAt);
                obj.setStatus(ProductStatus.of(intStatus));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public Product update(int id, Product updateObj) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update product " +
                    "set categoryId = ?, name = ?, description = ?, detail = ?, thumbnail = ?, price = ?, qty = ?, createdAt = ?, updatedAt = ?, status = ? where Id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, updateObj.getCategoryId());
            preparedStatement.setString(2, updateObj.getName());
            preparedStatement.setString(3, updateObj.getDescription());
            preparedStatement.setString(4, updateObj.getDetail());
            preparedStatement.setString(5, updateObj.getThumbnail());
            preparedStatement.setDouble( 6, updateObj.getPrice());
            preparedStatement.setInt(7, updateObj.getQty());
            preparedStatement.setString(8, updateObj.getCreatedAt().toString());
            preparedStatement.setString(9, updateObj.getUpdatedAt().toString());
            preparedStatement.setInt(10, updateObj.getStatus().getValue());
            preparedStatement.setInt(11, id);
            System.out.println("Connection success!");
            preparedStatement.execute();
            return updateObj;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update product " +
                    "set status = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, ProductStatus.DELETE.getValue());
            preparedStatement.setInt(2, id);
            System.out.println("Connection success!");
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Product> findByCateId(int categoryId) {
        List<Product> list = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from product where status = ? and categoryId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, CategoryStatus.ACTIVE.getValue());
            preparedStatement.setInt(2, categoryId);
            System.out.println("Connection success!");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                String detail = resultSet.getString("detail");
                String thumbnail = resultSet.getString("thumbnail");
                double price = resultSet.getDouble("price");
                int qty = resultSet.getInt("qty");
                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int intStatus= resultSet.getInt("status");
                Product obj = new Product();
                obj.setId(id);
                obj.setCategoryId(categoryId);
                obj.setName(name);
                obj.setDescription(description);
                obj.setDetail(detail);
                obj.setThumbnail(thumbnail);
                obj.setPrice(price);
                obj.setQty(qty);
                obj.setCreatedAt(createdAt);
                obj.setUpdatedAt(updatedAt);
                obj.setStatus(ProductStatus.of(intStatus));
                list.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
