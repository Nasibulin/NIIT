import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Nasibulin
 * Date: 28.09.18
 * Time: 8:41
 * To change this template use File | Settings | File Templates.
 */
public class CircleTest {
    @Test
    public void testDelta() throws Exception {
    assertEquals(0.15915494319051504,Circle.delta(1.0),0.00000000000000001);
    }
    @Test
    public void testperimeterTotal() throws Exception {
    assertEquals(50265.48245743669,Circle.perimeterTotal(3.0,1.0),0.00000000000000001);
    }
    @Test
    public void testroadTotal() throws Exception {
    assertEquals(21991.14857512855,Circle.roadTotal(3.0,1.0),0.00000000000000001);
    }
}
