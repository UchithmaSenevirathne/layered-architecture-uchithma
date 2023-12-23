package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.model.CustomDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryBO {
    public ArrayList<CustomDTO> customerOrderDetails(String name) throws SQLException, ClassNotFoundException;
}
