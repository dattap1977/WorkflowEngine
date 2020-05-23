package com.workflow;

import java.sql.SQLException;
import java.util.List;

public interface WorkFlow {
    List<String[]> runWorkFlowComponents(String workFlowJson);

}
