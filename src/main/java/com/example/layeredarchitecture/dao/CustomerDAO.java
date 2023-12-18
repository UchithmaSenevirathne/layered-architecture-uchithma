package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public interface CustomerDAO {
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException ;

    public boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException ;

    public void updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException ;
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException ;

    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException ;

    public String generateNewId() throws SQLException, ClassNotFoundException ;

    public CustomerDTO searchCustomer(String newValue) throws SQLException, ClassNotFoundException ;

}
