package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.SQLException;

public interface OrderBO {
    String generateNewId() throws SQLException, ClassNotFoundException;
    boolean exist(String orderId) throws SQLException, ClassNotFoundException;
    boolean save(OrderDTO orderDTO) throws SQLException, ClassNotFoundException;
}
