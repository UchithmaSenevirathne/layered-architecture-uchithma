package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.model.CustomDTO;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO {
    ArrayList<CustomDTO> customerOrderDetails(String search) throws SQLException, ClassNotFoundException;
}
