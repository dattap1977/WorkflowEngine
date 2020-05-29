package com.workflowSequence;

import com.component.Component;
import com.component.impl.ComponentImpl;
import com.dao.WorkFlowSequenceDAO;
import com.dao.impl.WorkFlowSequenceDAOImpl;
import com.to.WorkflowInfo;
import com.util.DbConnection;
import com.workflow.impl.WorkFlowImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class WorkFlowSequence {
   static String workFlowState = "0";
    public static int maxWorkFlowState = 3;
    static int cnt=0;
    boolean b1=false;


    public boolean addComponent(String comp) throws Exception{
        Component component = new ComponentImpl();
        boolean b1 = component.addComponent(comp,getCurrentWorkFlowState());

        return b1;
    }
    public void moveToNextState() throws ClassNotFoundException,SQLException{
         workFlowState = "" + Math.min((Integer.parseInt(getCurrentWorkFlowState()) + 1),maxWorkFlowState);
    }

    public boolean processListOfComponents(List<String[]> listOfComponents) throws Exception{
              int breakFlag = 0;
              Scanner sc = new Scanner(System.in);
        WorkFlowSequenceDAO workFlowSequenceDAO = new WorkFlowSequenceDAOImpl();

              for(String[] strArr : listOfComponents){
                  for(String comp : strArr){
                      b1 = addComponent(comp);
                      if (b1){
                         // continue;

                          workFlowSequenceDAO.insertIntoDbSequence();
                      }
                      else{
                          if (cnt == 0) {
                              moveToNextState();
                              workFlowSequenceDAO.updateIntoDbSequence();
                              cnt++;
                          }
                      }
//                      else{
//                          breakFlag = 1;
//                          break;
//                      }
                  }
//                  if (breakFlag == 1){
//                      break;
//                  }
//                  else{
                     if (b1) {
                         System.out.println("currentWorkFlowState = " + getCurrentWorkFlowState());
                         System.out.println("Do you want to move to the next state?(Y/N)");
                         String choice = sc.nextLine();
                         if (choice.equals("Y")) {
                             if (getCurrentWorkFlowState().equals("" + maxWorkFlowState)) {
                                 System.out.println("Maximum state has been reached. Exiting ...");
                                 System.exit(0);
                             } else {

                                 moveToNextState();
                                 workFlowSequenceDAO.updateIntoDbSequence();

                             }
                         } else {
                             System.exit(0);
                         }
                     }
                  //}
              }
              return true;
    }
    public static String getCurrentWorkFlowState() throws ClassNotFoundException,SQLException{
        Connection connection = DbConnection.getConnection();
        String sql = "select current_wf_step from workflow_sequence";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            workFlowState = resultSet.getString(1);
        }
        connection.close();
        return workFlowState;
    }

}
