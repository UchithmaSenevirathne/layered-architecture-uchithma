package lk.ijse.layeredarchitecture.dao.custom;

import lk.ijse.layeredarchitecture.dao.SuperDAO;
import lk.ijse.layeredarchitecture.entity.Custom;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {
    ArrayList<Custom> customerOrderDetails(String search) throws SQLException, ClassNotFoundException;
}
