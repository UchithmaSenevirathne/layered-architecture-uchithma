package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dao.CrudDAO;
import com.example.layeredarchitecture.model.OrderDTO;

public interface OrderDAO extends CrudDAO<OrderDTO> {
    /*public String generateNewOrderId() throws SQLException, ClassNotFoundException ;

    boolean searchOrderId(String orderId) throws SQLException, ClassNotFoundException;

    boolean saveOrder(OrderDTO orderDTO) throws SQLException, ClassNotFoundException;*/
}
