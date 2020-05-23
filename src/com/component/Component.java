package com.component;

public interface Component {
    boolean addComponent(String component,String workflowState) throws Exception;
    boolean removeComponent(String component);
}
