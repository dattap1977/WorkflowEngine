package com.component.impl;

import com.component.Component;
import com.componentIO.ComponentIO;
import com.componentIO.impl.ComponentIOImpl;
import com.dao.ComponentDAO;
import com.dao.impl.ComponentDAOImpl;
import com.util.DbConnection;
import com.workflow.impl.WorkFlowImpl;
import org.json.JSONObject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ComponentImpl implements Component {
    String componentName;
    Map<String, ArrayList<Property>> componentMap;
    @Override
    public boolean addComponent(String component,String workflowState) throws Exception {
        ComponentIO componentIO = new ComponentIOImpl();
        String componentJson = componentIO.readComponentFromJson(component);
        Map<String, ArrayList<Property>> componentMap = parse(componentJson);
        ComponentDAO componentDAO = new ComponentDAOImpl();
        boolean b1 = componentDAO.insertComponentIntoDatabase(component,workflowState,componentMap);
        componentDAO.insertComponentPropertiesIntoDatabase(componentMap,component);
//        for(Map.Entry<String, ArrayList<Property>> map : componentMap.entrySet()){
//            String compName = map.getKey();
//            System.out.println("Component Name = " + compName);
//            for(Property prop : map.getValue()){
//                System.out.print(" Property Key = " + prop.key);
//                System.out.println(" Property Value = " + prop.value);
//            }
//        }
        return b1;
    }

    @Override
    public boolean removeComponent(String component) {
        return true;
    }
    public static class Property{
        public String key;
        public String value;
    }

    Map<String, ArrayList<Property>> parse(String componentJson){
        JSONObject jsonObject = new JSONObject(componentJson);
        String componentName = jsonObject.getString("name");
        JSONObject conObj = jsonObject.optJSONObject("config");
        Map<String,ArrayList<Property>> map = new HashMap<>();
        ArrayList<Property> arList = new ArrayList<>();
        Iterator itr = conObj.keys();
        while(itr.hasNext()) {
            Property property = new Property();
            property.key = (String) itr.next();
            property.value = conObj.getString(property.key);
            arList.add(property);
        }
        map.put(componentName,arList);
        return map;
    }


}
