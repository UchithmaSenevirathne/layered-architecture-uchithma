package com.example.layeredarchitecture.dao.impl;

import com.example.layeredarchitecture.dao.OrderDetailDAO;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDetailDTO;
import com.example.layeredarchitecture.util.SQLUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderDetailDAOImpl implements OrderDetailDAO {

    @Override
    public boolean saveOrderDetails(OrderDetailDTO orderDetailDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)",
                orderDetailDTO.getOrderId(),
                orderDetailDTO.getItemCode(),
                orderDetailDTO.getUnitPrice(),
                orderDetailDTO.getQty());
    }
}
