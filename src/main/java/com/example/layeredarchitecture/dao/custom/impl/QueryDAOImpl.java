package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.custom.QueryDAO;
import com.example.layeredarchitecture.model.CustomDTO;
import com.example.layeredarchitecture.util.SQLUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public ArrayList<CustomDTO> customerOrderDetails(String search) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("select c.id, c.name, o.oid, o.date, i.description, od.qty, od.unitPrice from Customer c right join Orders o on c.id = o.customerID right join OrderDetails od on o.oid = od.oid right join item i on i.code = od.itemCode where c.name = ?", search);

        ArrayList<CustomDTO> customDTOS = new ArrayList<>();

        while(rst.next()){
            CustomDTO customDTO = new CustomDTO(
                    rst.getString("id"),
                    rst.getString("name"),
                    rst.getString("oid"),
                    rst.getString("description"),
                    rst.getInt("qty"),
                    rst.getBigDecimal("unitPrice"),
                    rst.getString("date")
            );
            customDTOS.add(customDTO);
            System.out.println(customDTOS);
        }
        return customDTOS;
    }
}
