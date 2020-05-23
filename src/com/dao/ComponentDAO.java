package com.dao;

import com.component.impl.ComponentImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public interface ComponentDAO {
    public boolean insertComponentIntoDatabase(String component, String workflowState, Map<String, ArrayList<ComponentImpl.Property>> componentMap) throws ClassNotFoundException, SQLException ;
    public void insertComponentPropertiesIntoDatabase(Map<String,ArrayList<ComponentImpl.Property>> componentMap, String component) throws ClassNotFoundException,SQLException;
}
