package com.workflow.impl;

import com.to.WorkflowInfo;
import com.util.DbConnection;
import com.workflow.WorkFlow;
import com.workflowSequence.WorkFlowSequence;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class WorkFlowImpl implements WorkFlow {
    static String workFlowName;
    List<String[]> components;
    @Override
    public List<String[]> runWorkFlowComponents(String workFlowJson) {
        //System.out.println("w1 = " + workFlowJson);
        JSONObject jsonObject = new JSONObject(workFlowJson);
        workFlowName = jsonObject.getString("name");

        JSONObject conObj = jsonObject.getJSONObject("connections");
//
        components = new ArrayList<>();
        for(int i1=0; i1 <= WorkFlowSequence.maxWorkFlowState; i1++){
            JSONArray comArr1 = conObj.getJSONArray("" + i1);

        String[] com1 = new String[comArr1.length()];
        for(int i=0; i < comArr1.length(); i++){
            com1[i] = comArr1.getString(i);

        }
        components.add(com1);
        }
        return components;
    }


    public static String getWorkFlowName(){
        return workFlowName;
    }
}
