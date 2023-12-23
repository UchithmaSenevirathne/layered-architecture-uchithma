package lk.ijse.layeredarchitecture.dao.custom.impl;

import lk.ijse.layeredarchitecture.dao.custom.QueryDAO;
import lk.ijse.layeredarchitecture.entity.Custom;
import lk.ijse.layeredarchitecture.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public ArrayList<Custom> customerOrderDetails(String name) throws SQLException, ClassNotFoundException {
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

        ArrayList<Custom> customs = new ArrayList<>();

        while(rst.next()){
            Custom custom = new Custom(
                    rst.getString("id"),
                    rst.getString("name"),
                    rst.getString("oid"),
                    rst.getString("description"),
                    rst.getInt("qty"),
                    rst.getBigDecimal("unitPrice"),
                    rst.getString("date")
            );
            customs.add(custom);
            System.out.println(customs);
        }
        return customs;
    }
}
