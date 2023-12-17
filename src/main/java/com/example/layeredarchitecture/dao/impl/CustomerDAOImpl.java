package com.example.layeredarchitecture.dao.impl;

import com.example.layeredarchitecture.dao.CustomerDAO;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.util.SQLUtil;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer");

        ArrayList<CustomerDTO> customerDTOS = new ArrayList<>();

        while (rst.next()){
            CustomerDTO customerDTO = new CustomerDTO(
                    rst.getString("id"),
                    rst.getString("name"),
                    rst.getString("address")
            );
            customerDTOS.add(customerDTO);
        }
        return customerDTOS;
    }

    @Override
    public boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Customer (id,name, address) VALUES (?,?,?)",
                dto.getId(),
                dto.getName(),
                dto.getAddress());
    }

    @Override
    public void updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        boolean isUpdated = SQLUtil.execute("UPDATE Customer SET name=?, address=? WHERE id=?",
                dto.getName(),
                dto.getAddress(),
                dto.getId());
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM Customer WHERE id=?", id);
    }

    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT id FROM Customer WHERE id=?", id);

        return resultSet.next();
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("id");
            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newCustomerId);
        } else {
            return "C00-001";
        }
    }

    public CustomerDTO searchCustomer(String newValue) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer WHERE id=?", newValue);

        CustomerDTO customerDTO = null;
        if(rst.next()) {
            customerDTO = new CustomerDTO(
                    newValue + "",
                    rst.getString("name"),
                    rst.getString("address"));
        }

        return customerDTO;
    }

    @Override
    public ArrayList<CustomerDTO> loadAllCustomerIds() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer");
        ArrayList<CustomerDTO> customerDTOS = new ArrayList<>();

        while (rst.next()) {
            CustomerDTO customerDTO = new CustomerDTO(
                    rst.getString("id"),
                    rst.getString("name"),
                    rst.getString("address")
            );
            customerDTOS.add(customerDTO);
        }
        return customerDTOS;
    }
}
