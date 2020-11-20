import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import ru.chuchnakov.Demo;
import org.junit.Test;
import ru.chuchnakov.Solution;

import javax.swing.*;
import javax.swing.JOptionPane.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Tester {
private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
@Before
public void setUp(){
    System.setOut(new PrintStream(outputStream));
    }

@Test
    public void setSayHello() {
    //Demo demo = new Demo();
    //demo.testsayHello();
   // Assert.assertEquals("hello",outputStream.toString());
    /*
    String inPut = JOptionPane.showInputDialog(
            null,
            "Введите число",
            "Strobogrammatic",
            JOptionPane.QUESTION_MESSAGE
    );
     */
    Solution solution = new Solution();
    // Ex 1
    boolean result= solution.isStrobogrammatic("69");
    Assert.assertEquals(result,true);

    result= solution.isStrobogrammatic("88");
    Assert.assertEquals(result,true);

    result= solution.isStrobogrammatic("962");
    Assert.assertEquals(result,false);

    result= solution.isStrobogrammatic("1");
    Assert.assertEquals(result,true);

    // Ex 2
    //--------------------------------------------------------------

     result = solution.isPowerOfFour(16);
    Assert.assertEquals(result,true);

    result = solution.isPowerOfFour(5);
    Assert.assertEquals(result,false);

    result = solution.isPowerOfFour(1);
    Assert.assertEquals(result,true);

    result = solution.isPowerOfFour(256);
    Assert.assertEquals(result,true);

    result = solution.isPowerOfFour(1020);
    Assert.assertEquals(result,false);

}
@After
public void cleanUp(){
    System.setOut(null);
}
}
