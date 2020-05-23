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
        JSONArray comArr1 = conObj.getJSONArray("0");
        components = new ArrayList<>();
        String[] com1 = new String[comArr1.length()];
        for(int i=0; i < comArr1.length(); i++){
            com1[i] = comArr1.getString(i);

        }
        components.add(com1);
        JSONArray comArr2 = conObj.getJSONArray("1");
        String[] com2 = new String[comArr2.length()];
        for(int i=0; i < comArr2.length(); i++){
            com2[i] = comArr2.getString(i);

        }
        components.add(com2);
        JSONArray comArr3 = conObj.getJSONArray("2");
        String[] com3 = new String[comArr3.length()];
        for(int i=0; i < comArr3.length(); i++){
            com3[i] = comArr3.getString(i);
        }
        components.add(com3);

        return components;
    }


    public static String getWorkFlowName(){
        return workFlowName;
    }
}
