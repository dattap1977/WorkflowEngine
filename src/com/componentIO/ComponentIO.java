package com.componentIO;

import com.component.impl.ComponentImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public interface ComponentIO {
    String readComponentFromJson(String component) throws IOException;
}
