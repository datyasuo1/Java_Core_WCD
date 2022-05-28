package com.example.karma_shops.entity.shoppingcart;

import com.example.karma_shops.entity.myenum.ShoppingCartStatus;
import com.example.karma_shops.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class MySQLShoppingCartModel implements ShoppingCartModel{
    @Override
    public ShoppingCart save(ShoppingCart shoppingCart) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "insert into shoppingcart "+
                    "(userId,shipName,shipPhone,shipAddress,shipNote,totalPrice,createdAt,status)"+
                    " value "+"(?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1,1);
            preparedStatement.setString(2,shoppingCart.getShipName());
            preparedStatement.setString(3,shoppingCart.getShipPhone());
            preparedStatement.setString(4,shoppingCart.getShipAddress());
            preparedStatement.setString(5,shoppingCart.getShipNote());
            preparedStatement.setDouble(6,shoppingCart.getTotalPrice());
            preparedStatement.setString(7, LocalDateTime.now().toString());
            preparedStatement.setInt(8, ShoppingCartStatus.ACTIVE.getValue());
            System.out.println("Connection success!");
            preparedStatement.execute();
            return shoppingCart;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ShoppingCart> findAll() {
        List<ShoppingCart> list = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from shoppingcart";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = Integer.parseInt(resultSet.getString("id"));
                int userId = Integer.parseInt(resultSet.getString("userId"));
                String shipName = resultSet.getString("shipName");
                String shipPhone = resultSet.getString("shipPhone");
                String shipAddress = resultSet.getString("shipAddress");
                String shipNote = resultSet.getString("shipNote");
                double totalPrice = Double.parseDouble(resultSet.getString("totalPrice"));
                LocalDateTime createdAt = LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                int status = Integer.parseInt(resultSet.getString("status"));
                ShoppingCart shoppingCart = new ShoppingCart();
                shoppingCart.setId(id);
                shoppingCart.setUserId(userId);
                shoppingCart.setShipName(shipName);
                shoppingCart.setShipPhone(shipPhone);
                shoppingCart.setShipAddress(shipAddress);
                shoppingCart.setShipNote(shipNote);
                shoppingCart.setTotalPrice(totalPrice);
                shoppingCart.setCreatedAt(createdAt);
                shoppingCart.setStatus(ShoppingCartStatus.of(status));
                list.add(shoppingCart);
            }
            preparedStatement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ShoppingCart findById(int id) {
        ShoppingCart shoppingCart = null;
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from shoppingcart where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int userId = Integer.parseInt(resultSet.getString("userId"));
                String shipName = resultSet.getString("shipName");
                String shipPhone = resultSet.getString("shipPhone");
                String shipAddress = resultSet.getString("shipAddress");
                String shipNote = resultSet.getString("shipNote");
                double totalPrice = Double.parseDouble(resultSet.getString("totalPrice"));
                LocalDateTime createdAt = LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                int status = Integer.parseInt(resultSet.getString("status"));
                shoppingCart.setId(id);
                shoppingCart.setUserId(userId);
                shoppingCart.setShipName(shipName);
                shoppingCart.setShipPhone(shipPhone);
                shoppingCart.setShipAddress(shipAddress);
                shoppingCart.setShipNote(shipNote);
                shoppingCart.setTotalPrice(totalPrice);
                shoppingCart.setCreatedAt(createdAt);
                shoppingCart.setStatus(ShoppingCartStatus.of(status));
            }
            preparedStatement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return shoppingCart;
    }
}
