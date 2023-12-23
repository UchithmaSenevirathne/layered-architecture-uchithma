package lk.ijse.layeredarchitecture.bo.custom.impl;

import lk.ijse.layeredarchitecture.bo.custom.QueryBO;
import lk.ijse.layeredarchitecture.dao.DAOFactory;
import lk.ijse.layeredarchitecture.dao.custom.QueryDAO;
import lk.ijse.layeredarchitecture.dto.CustomDTO;
import lk.ijse.layeredarchitecture.entity.Custom;

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
