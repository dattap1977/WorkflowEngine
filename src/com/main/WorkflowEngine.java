package com.main;

import com.dao.WorflowDAO;
import com.dao.impl.WorkFlowDAOImpl;
import com.workflowIO.WorkFlowIO;
import com.workflowIO.impl.WorkFlowIOImpl;
import com.workflow.WorkFlow;
import com.workflow.impl.WorkFlowImpl;
import com.workflowSequence.WorkFlowSequence;

import java.io.IOException;
import java.util.List;

public class WorkflowEngine {
    public static void main(String[] args) throws Exception {
        WorkFlowIO workFlowIO = new WorkFlowIOImpl();
        String workFlowJson = workFlowIO.readWorkflowInput();
        WorkFlow workFlow = new WorkFlowImpl();
        List<String[]> listOfComponents = workFlow.runWorkFlowComponents(workFlowJson);
       // workFlow.insertIntoDatabase();
        WorflowDAO worflowDAO = new WorkFlowDAOImpl();
        worflowDAO.insertIntoDatabase(WorkFlowImpl.getWorkFlowName(),listOfComponents);
        WorkFlowSequence workFlowSequence = new WorkFlowSequence();
        workFlowSequence.processListOfComponents(listOfComponents);
    }
}
