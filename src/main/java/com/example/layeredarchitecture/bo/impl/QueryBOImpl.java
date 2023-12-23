package com.example.layeredarchitecture.bo.impl;

import com.example.layeredarchitecture.bo.QueryBO;
import com.example.layeredarchitecture.dao.custom.QueryDAO;
import com.example.layeredarchitecture.dao.custom.impl.QueryDAOImpl;
import com.example.layeredarchitecture.model.CustomDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class QueryBOImpl implements QueryBO {
    QueryDAO queryDAO = new QueryDAOImpl();
    @Override
    public ArrayList<CustomDTO> customerOrderDetails(String name) throws SQLException, ClassNotFoundException {
        return queryDAO.customerOrderDetails(name);
    }
}
