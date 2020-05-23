package com.dao;

import java.sql.SQLException;
import java.util.List;

public interface WorflowDAO {
    public void insertIntoDatabase(String workFlowName, List<String[]> components) throws SQLException,ClassNotFoundException ;
}
