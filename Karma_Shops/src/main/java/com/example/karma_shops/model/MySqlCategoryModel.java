package com.example.karma_shops.model;

import com.example.karma_shops.entity.Category;
import com.example.karma_shops.entity.myenum.CategoryStatus;
import com.example.karma_shops.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class MySqlCategoryModel implements CategoryModel{

    @Override
    public Category create(Category obj) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "insert into category " +
                    "( name, createdAt, updatedAt, status) " +
                    "values " +
                    "(?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, obj.getName());
            preparedStatement.setString(2, obj.getCreatedAt().toString());
            preparedStatement.setString(3, obj.getUpdatedAt().toString());
            preparedStatement.setInt(4, obj.getStatus().getValue());
            System.out.println("Connection success!");
            preparedStatement.execute();
            return obj;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Category> findAll() {
        List<Category> list = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from category where status = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, CategoryStatus.ACTIVE.getValue());
            System.out.println("Connection success!");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int intStatus= resultSet.getInt("status");
                Category obj = new Category(id,name);
                obj.setCreatedAt(createdAt);
                obj.setUpdatedAt(updatedAt);
                obj.setStatus(CategoryStatus.of(intStatus));
                list.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Category findById(int id) {
        Category obj = null;
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from category where status = ? and id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, CategoryStatus.ACTIVE.getValue());
            preparedStatement.setInt(2, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                String name = resultSet.getString("name");
                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int intStatus= resultSet.getInt("status");
                obj = new Category(id,name);
                obj.setCreatedAt(createdAt);
                obj.setUpdatedAt(updatedAt);
                obj.setStatus(CategoryStatus.of(intStatus));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;    }


    @Override
    public Category update(int id, Category updateObj) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update category " +
                    "set Name = ? , createdAt = ?, updatedAt = ?, status = ? where Id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, updateObj.getName());
            preparedStatement.setString(2, updateObj.getCreatedAt().toString());
            preparedStatement.setString(3, updateObj.getUpdatedAt().toString());
            preparedStatement.setInt(4, updateObj.getStatus().getValue());
            preparedStatement.setInt(5, id);
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
            String sqlQuery = "update category " +
                    "set status = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, CategoryStatus.DELETE.getValue());
            preparedStatement.setInt(2, id);
            System.out.println("Connection success!");
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
