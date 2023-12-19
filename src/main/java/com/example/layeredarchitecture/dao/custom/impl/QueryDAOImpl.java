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
    public ArrayList<CustomDTO> customerOrderDetails(String name) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("select\n" +
                "   c.id,\n" +
                "   c.name,\n" +
                "   o.oid,\n" +
                "   o.date,\n" +
                "   i.description,\n" +
                "   od.qty,\n" +
                "   od.unitPrice\n" +
                "from\n" +
                "   Customer c\n" +
                "       right join\n" +
                "   Orders o on c.id = o.customerID\n" +
                "       right join\n" +
                "   OrderDetails od on o.oid = od.oid\n" +
                "       right join\n" +
                "   item i on i.code = od.itemCode\n" +
                "where c.name = ?",
                name);

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
