package com.dao.impl;

import com.dao.WorflowDAO;
import com.util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class WorkFlowDAOImpl implements WorflowDAO {
    public void insertIntoDatabase(String workFlowName, List<String[]> components) throws SQLException,ClassNotFoundException {
        Connection connection = DbConnection.getConnection();
        String selectSQL = "select * from workflow where workflow_name = ?";
        PreparedStatement ps = connection.prepareStatement(selectSQL);
        ps.setString(1,workFlowName);
        ResultSet rs = ps.executeQuery();
        boolean existFlag = false;
        while (rs.next()){
            existFlag = true;
        }
        if (!existFlag) {
            String sql = "insert into workflow values (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            int count = 0;
            for (String[] comp : components) {
                preparedStatement.setString(1, workFlowName);
                preparedStatement.setString(2, "" + count);
                for (int j = 0; j < comp.length; j++) {
                    preparedStatement.setString(j + 3, comp[j]);
                }
                for (int j = comp.length; j < 3; j++) {
                    preparedStatement.setString(j + 3, null);
                }
                preparedStatement.executeUpdate();
                count++;
            }
        }
        connection.close();
    }
}
