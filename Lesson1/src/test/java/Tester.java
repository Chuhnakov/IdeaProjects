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
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void setSayHello() {

        Solution solution = new Solution();
        // Ex 1
        boolean result = solution.isStrobogrammatic("69");
        Assert.assertTrue(result);

        result = solution.isStrobogrammatic("88");
        Assert.assertTrue(result);

        result = solution.isStrobogrammatic("962");
        Assert.assertFalse(result);

        result = solution.isStrobogrammatic("1");
        Assert.assertTrue(result);

        // Ex 2
        //--------------------------------------------------------------

        result = solution.isPowerOfFour(16);
        Assert.assertTrue(result);

        result = solution.isPowerOfFour(5);
        Assert.assertFalse(result);

        result = solution.isPowerOfFour(1);
        Assert.assertTrue(result);

        result = solution.isPowerOfFour(256);
        Assert.assertTrue(result);

        result = solution.isPowerOfFour(1020);
        Assert.assertFalse(result);

    }

    @After
    public void cleanUp() {
        System.setOut(null);
    }
}
