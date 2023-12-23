package com.example.layeredarchitecture.bo.custom.impl;

import com.example.layeredarchitecture.bo.custom.QueryBO;
import com.example.layeredarchitecture.dao.DAOFactory;
import com.example.layeredarchitecture.dao.custom.QueryDAO;
import com.example.layeredarchitecture.dto.CustomDTO;
import com.example.layeredarchitecture.entity.Custom;
import com.example.layeredarchitecture.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class QueryBOImpl implements QueryBO {
    QueryDAO queryDAO = (QueryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.QUERY);

    @Override
    public ArrayList<CustomDTO> customerOrderDetails(String name) throws SQLException, ClassNotFoundException {
        ArrayList<Custom> customs = queryDAO.customerOrderDetails(name);
        ArrayList<CustomDTO> customDTOS = new ArrayList<>();

        for(Custom custom : customs){
            customDTOS.add(new CustomDTO(custom.getId(), custom.getName(), custom.getName(), custom.getItemDescription(), custom.getQty(), custom.getUnitPrice(), custom.getOrderDate()));
        }
        return customDTOS;
    }
}
