package test;


import com.component.impl.ComponentImpl;
import org.junit.Assert;
import org.junit.Test;

public class ComponentImplTest {

    @Test
    public void addComponentNotExistTest() throws Exception{
        ComponentImpl componentImpl = new ComponentImpl();
        boolean b1 = componentImpl.addComponent("Add Lead Name","0");
        Assert.assertEquals(true,b1);
    }


//
}