package lk.ijse.layeredarchitecture.bo.custom;

import lk.ijse.layeredarchitecture.bo.SuperBO;
import lk.ijse.layeredarchitecture.dto.CustomDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryBO extends SuperBO {
    ArrayList<CustomDTO> customerOrderDetails(String name) throws SQLException, ClassNotFoundException;
}
