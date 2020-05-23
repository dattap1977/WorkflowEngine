package com.dao.impl;

import com.dao.WorkFlowSequenceDAO;
import com.util.DbConnection;
import com.workflow.impl.WorkFlowImpl;
import com.workflowSequence.WorkFlowSequence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WorkFlowSequenceDAOImpl implements WorkFlowSequenceDAO {
    public void insertIntoDbSequence() throws ClassNotFoundException, SQLException {
        Connection connection = DbConnection.getConnection();
        String sql = "insert into workflow_sequence values(?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        String workflowName = WorkFlowImpl.getWorkFlowName();
        preparedStatement.setString(1,workflowName);
        preparedStatement.setString(2, WorkFlowSequence.getCurrentWorkFlowState());
        preparedStatement.setString(3,"" + Math.min(WorkFlowSequence.maxWorkFlowState,(Integer.parseInt(WorkFlowSequence.getCurrentWorkFlowState()) + 1)));
        preparedStatement.executeUpdate();
        connection.close();
    }

    public void updateIntoDbSequence() throws ClassNotFoundException, SQLException{
        Connection connection = DbConnection.getConnection();
        String sql = "update workflow_sequence set current_wf_step = ? where workflow_name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        String workflowName = WorkFlowImpl.getWorkFlowName();

        preparedStatement.setString(1,"" + (Integer.parseInt(WorkFlowSequence.getCurrentWorkFlowState()) + 1));
        preparedStatement.setString(2,workflowName);
        preparedStatement.executeUpdate();
        connection.close();
    }
}
