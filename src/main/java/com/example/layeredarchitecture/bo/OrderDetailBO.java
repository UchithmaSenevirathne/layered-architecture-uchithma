package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;

public interface OrderDetailBO {
    public boolean save(OrderDetailDTO orderDetailDTO) throws SQLException, ClassNotFoundException;
}
