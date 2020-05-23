package com.componentIO.impl;

import com.component.impl.ComponentImpl;
import com.componentIO.ComponentIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class ComponentIOImpl implements ComponentIO {
    @Override
    public String readComponentFromJson(String component) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("src/com/inputFile/" + component + ".txt") ));

        String inputData = null;
        String componentJson = "";
        while((inputData = br.readLine()) != null){
            componentJson = componentJson + inputData;
        }

        return componentJson;
    }
}
