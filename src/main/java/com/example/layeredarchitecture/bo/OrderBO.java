package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.SQLException;

public interface OrderBO {
    public String generateNewId() throws SQLException, ClassNotFoundException;
    public boolean exist(String orderId) throws SQLException, ClassNotFoundException;
    public boolean save(OrderDTO orderDTO) throws SQLException, ClassNotFoundException;
}
