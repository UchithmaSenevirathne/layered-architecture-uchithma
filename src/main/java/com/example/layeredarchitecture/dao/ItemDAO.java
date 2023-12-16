package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public interface ItemDAO {
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException ;

    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException ;
    public boolean saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException ;

    public boolean updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException ;

    public boolean existItem(String code) throws SQLException, ClassNotFoundException ;

    public String generateNewId() throws SQLException, ClassNotFoundException ;

    public ItemDTO searchItem(String newItemCode) throws SQLException, ClassNotFoundException ;
}
