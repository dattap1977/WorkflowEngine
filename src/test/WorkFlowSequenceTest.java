package test;


import com.workflowSequence.WorkFlowSequence;
import org.junit.Assert;
import org.junit.Test;

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
//    @Test
//    void outputShouldOutputRuler() {
//        AlliancesTO alliances = new AlliancesTO();
//        String[] res = {"Air","Land","Water"};
//        KingdomImpl kingdom = new KingdomImpl();
//        kingdom.setAlliancesList(res);
//        MessageOutputContext kingShanMessageOutputContext = new MessageOutputContext();
//
//        String expectedOutput = "Who is the ruler of Southeros?" + "\n"
//                + "King Shan" + "\n"
//                + "Allies of Ruler" + "\n"
//                + alliances.toString() + "\n";
//        Assert.assertEquals(expectedOutput,kingShanMessageOutputContext.output(kingdom));
//    }
//
//    @Test
//    void outputShouldOutputNonRuler(){
//        AlliancesTO alliances = new AlliancesTO();
//        String[] res = {"Land","Water"};
//        KingdomImpl kingdom = new KingdomImpl();
//        kingdom.setAlliancesList(res);
//        MessageOutputContext kingShanMessageOutputContext = new MessageOutputContext();
//
//        String expectedOutput = "Who is the ruler of Southeros?" + "\n"
//                + "None" + "\n"
//                + "Allies of Ruler" + "\n"
//                +  "None" + "\n";
//        Assert.assertEquals(expectedOutput,kingShanMessageOutputContext.output(kingdom));
//    }
}