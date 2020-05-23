package test;


import com.workflow.impl.WorkFlowImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class WorkFlowImplTest {
      @Test
      public void runWorkFlowComponentsTest(){
          String workFlowJson = "{\n" +
                  "\t\"name\": \"workflow name 1\",\n" +
                  "\t\"connections\": {\n" +
                  "\t\t\"0\": [\"Add Lead Name\"],\n" +
                  "\t\t\"1\": [\"Add Lead Description\"],\n" +
                  "\t\t\"2\": [\"Add Lead Country\"]\n" +
                  "\t}\n" +
                  "}";
          WorkFlowImpl workFlowImpl = new WorkFlowImpl();
         List<String[]> list =  workFlowImpl.runWorkFlowComponents(workFlowJson);
         String[] firstComponent = {"Add Lead Name"};


          String[] firstComp = null;
          for(String[] sArr : list){
              firstComp = sArr;
              break;
          }
          Assert.assertEquals(firstComponent[0],firstComp[0]);

      }
//
}