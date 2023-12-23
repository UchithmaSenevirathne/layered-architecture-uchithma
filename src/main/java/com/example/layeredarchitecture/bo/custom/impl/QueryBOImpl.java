package com.example.layeredarchitecture.bo.custom.impl;

import com.example.layeredarchitecture.bo.custom.QueryBO;
import com.example.layeredarchitecture.dao.DAOFactory;
import com.example.layeredarchitecture.dao.custom.QueryDAO;
import com.example.layeredarchitecture.model.CustomDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class QueryBOImpl implements QueryBO {
    QueryDAO queryDAO = (QueryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.QUERY);

    @Override
    public ArrayList<CustomDTO> customerOrderDetails(String name) throws SQLException, ClassNotFoundException {
        return queryDAO.customerOrderDetails(name);
    }
}
