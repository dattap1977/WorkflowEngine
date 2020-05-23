package com.dao;

import java.sql.SQLException;

public interface WorkFlowSequenceDAO {
    public void insertIntoDbSequence() throws ClassNotFoundException, SQLException;
    public void updateIntoDbSequence() throws ClassNotFoundException, SQLException;
}
