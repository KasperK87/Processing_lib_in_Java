
import myClasses.MyObject;
import processing.core.PApplet;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AppTest {
    @Test
    public void testApp(){
        //arrange
        MyObject obj = new MyObject(new PApplet(), 0, 0, 100, 100, 0);
        //act
        //assert
        assertEquals(obj.getW(), 100);
    }
}
