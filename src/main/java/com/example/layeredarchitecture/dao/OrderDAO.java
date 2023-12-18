package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public interface OrderDAO extends CrudDAO<OrderDTO>{
    /*public String generateNewOrderId() throws SQLException, ClassNotFoundException ;

    boolean searchOrderId(String orderId) throws SQLException, ClassNotFoundException;

    boolean saveOrder(OrderDTO orderDTO) throws SQLException, ClassNotFoundException;*/
}
