package test;


import com.workflowSequence.WorkFlowSequence;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class WorkFlowSequenceTest {
    @Test
    public void processListOfComponents() throws Exception{
        WorkFlowSequence workFlowSequence = new WorkFlowSequence();
        String[] firstComponent = {"Add Lead Name"};
        String[] secondComponent = {"Add Lead Description"};
        String[] thirdComponent = {"Add Lead Country"};
        List<String[]> listOfComponents = new ArrayList<>();
        listOfComponents.add(firstComponent);
        listOfComponents.add(secondComponent);
        listOfComponents.add(thirdComponent);
        boolean b1 = workFlowSequence.processListOfComponents(listOfComponents);
        Assert.assertEquals(true,b1);
    }

}