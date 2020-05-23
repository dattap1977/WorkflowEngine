package com.dao.impl;

import com.component.impl.ComponentImpl;
import com.dao.ComponentDAO;
import com.util.DbConnection;
import com.workflow.impl.WorkFlowImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public class ComponentDAOImpl implements ComponentDAO {
    public boolean insertComponentIntoDatabase(String component, String workflowState, Map<String, ArrayList<ComponentImpl.Property>> componentMap) throws ClassNotFoundException, SQLException {
        Connection connection = DbConnection.getConnection();
        String workFlowName = WorkFlowImpl.getWorkFlowName();
        String selectSQL = "select component_name from component where workflow_name = ?";
        PreparedStatement ps = connection.prepareStatement(selectSQL);
        boolean existFlag = false;
        ps.setString(1,workFlowName);
        ResultSet rs = ps.executeQuery();
        //System.out.println("comp = " + component);
        while(rs.next()){
            if (component.equals(rs.getString(1))) {
                existFlag = true;
                break;
            }

        }
        if (!existFlag){
            String insertSQL = "insert into component values(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1,workFlowName);
            preparedStatement.setString(2,component);
            preparedStatement.setString(3,workflowState);
            preparedStatement.executeUpdate();
        }
        connection.close();
        return !existFlag;
    }

    public void insertComponentPropertiesIntoDatabase(Map<String,ArrayList<ComponentImpl.Property>> componentMap, String component) throws ClassNotFoundException,SQLException{
        Connection connection = DbConnection.getConnection();
        //String workFlowName = WorkFlowImpl.getWorkFlowName();
        String selectSQL = "select component_name from componentProperty where component_name = ?";
        PreparedStatement ps = connection.prepareStatement(selectSQL);
        boolean existFlag = false;
        ps.setString(1,component);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            existFlag = true;
        }
        if (!existFlag){
            String insertSQL = "insert into componentProperty values(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
            for(Map.Entry<String, ArrayList<ComponentImpl.Property>> map : componentMap.entrySet()){
                String compName = map.getKey();
                System.out.println("Component Name = " + compName);
                for(ComponentImpl.Property prop : map.getValue()){
                    System.out.print(" Property Key = " + prop.key);
                    System.out.println(" Property Value = " + prop.value);
                    String propKey = prop.key;
                    String propValue = prop.value;
                    preparedStatement.setString(1,compName);
                    preparedStatement.setString(2,propKey);
                    preparedStatement.setString(3,propValue);
                    preparedStatement.executeUpdate();

                }
            }
        }
        connection.close();
    }

}
