package com.workflowIO.impl;

import com.workflowIO.WorkFlowIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class WorkFlowIOImpl implements WorkFlowIO {

    @Override
    public String readWorkflowInput() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("src/com/inputFile/workflowEngine.txt") ));

        String inputData = null;
        String workFlowJson = "";
        while((inputData = br.readLine()) != null){
            workFlowJson = workFlowJson + inputData;
        }

        return workFlowJson;
    }
}
