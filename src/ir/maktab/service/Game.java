package ir.maktab.service;

import ir.maktab.model.Play;

import java.sql.SQLException;
import java.util.List;

public interface Game {
    void addPlayToTable(Play play) throws SQLException;
    void deletePlayOfTable(String name) throws SQLException;
    List getPlaysOfTable(String name) throws SQLException;


}
