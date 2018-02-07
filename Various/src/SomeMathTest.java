import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class SomeMathTest {
    @Parameter(0)
    public Integer m1;
    @Parameter(1)
    public Integer m2;
    @Parameter(2)
    public Integer result;

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {{1,1,2},{1,2,3},{2,2,4}};
        return Arrays.asList(data);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdditionException() {
        SomeMath tester = new SomeMath();
        tester.doAddition(1000,1);
    }

    @Test
    public void testAddition() {
        SomeMath tester = new SomeMath();
        assertEquals("Result", result, tester.doAddition(m1,m2));
    }
}
