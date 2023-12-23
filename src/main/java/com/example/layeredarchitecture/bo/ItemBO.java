package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO {
    ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException;
    boolean delete(String code) throws SQLException, ClassNotFoundException;
    boolean save(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
    boolean update(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
    boolean exist(String code) throws SQLException, ClassNotFoundException;
    String generateNewId() throws SQLException, ClassNotFoundException;
    ItemDTO search(String newItemCode) throws SQLException, ClassNotFoundException;
}