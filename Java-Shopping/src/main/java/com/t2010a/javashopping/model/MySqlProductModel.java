package com.t2010a.javashopping.model;

import com.t2010a.javashopping.entity.Product;
import com.t2010a.javashopping.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class MySqlProductModel implements ProductModel{
    @Override
    public Product save(Product product) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "insert into products "+
                    "(id,name,price,content,size,qty,sku,category,tag,createdAt,updatedAt,status)"+
                    "value "+"(?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1,product.getId());
            preparedStatement.setString(2,product.getName());
            preparedStatement.setDouble(3,product.getPrice());
            preparedStatement.setString(4,product.getContent());
            preparedStatement.setString(5,product.getSize());
            preparedStatement.setInt(6,product.getQty());
            preparedStatement.setInt(7,product.getSku());
            preparedStatement.setString(8,product.getCategory());
            preparedStatement.setString(9,product.getTag());
            preparedStatement.setString(10,product.getCreatedAt().toString());
            preparedStatement.setString(11,product.getUpdatedAt().toString());
            preparedStatement.setInt(12,product.getStatus());
            System.out.println("Connection success!");
            preparedStatement.execute();
            return product;
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
            String sqlQuery = "select * from products where status = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1,1);
            System.out.println("Connection success!");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String content = resultSet.getString("content");
                String size = resultSet.getString("size");
                int qty = resultSet.getInt("qty");
                int sku = resultSet.getInt("sku");
                String category = resultSet.getString("category");
                String tag = resultSet.getString("tag");
                LocalDateTime createdAt = LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt = LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                int status = resultSet.getInt("status");
                Product product = new Product(id,name,price,content,size,qty,sku,category,tag,createdAt,updatedAt,status);
                list.add(product);
            }
            preparedStatement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Product findById(String id) {
        Product product = null;
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from products where status = ? and id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1,1);
            preparedStatement.setString(2,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String content = resultSet.getString("content");
                String size = resultSet.getString("size");
                int qty = resultSet.getInt("qty");
                int sku = resultSet.getInt("sku");
                String category = resultSet.getString("category");
                String tag = resultSet.getString("tag");
                LocalDateTime createdAt = LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt = LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                int status = resultSet.getInt("status");
                product = new Product(id,name,price,content,size,qty,sku,category,tag,createdAt,updatedAt,status);
            }
            preparedStatement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public Product update(String id, Product product) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update products "+
                    "set id = ?,name = ?,price = ?,content = ?,size = ?,qty = ?,sku = ?,category = ?,tag = ? , createdAt = ?,updatedAt = ? ,status = ? where  id =?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1,product.getId());
            preparedStatement.setString(2,product.getName());
            preparedStatement.setDouble(3,product.getPrice());
            preparedStatement.setString(4,product.getContent());
            preparedStatement.setString(5,product.getSize());
            preparedStatement.setInt(6,product.getQty());
            preparedStatement.setInt(7,product.getSku());
            preparedStatement.setString(8,product.getCategory());
            preparedStatement.setString(9,product.getTag());
            preparedStatement.setString(10,product.getCreatedAt().toString());
            preparedStatement.setString(11,product.getUpdatedAt().toString());
            preparedStatement.setInt(12,product.getStatus());
            preparedStatement.setString(13,id);
            System.out.println("Connection success!");
            preparedStatement.execute();
            return product;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update products " +
                    "set status = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1,-1);
            preparedStatement.setString(2,id);
            System.out.println("Connection success!");
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
