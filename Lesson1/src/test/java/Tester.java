import org.junit.Assert;
import org.junit.Test;
import ru.chuchnakov.Solution;
import java.io.ByteArrayOutputStream;

public class Tester {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
   private Solution solution = new Solution();
   private boolean result;
    @Test
    public void testStrobogrammatic() {

        result = solution.isStrobogrammatic("69");
        Assert.assertTrue(result);

        result = solution.isStrobogrammatic("88");
        Assert.assertTrue(result);

        result = solution.isStrobogrammatic("962");
        Assert.assertFalse(result);

        result = solution.isStrobogrammatic("1");
        Assert.assertTrue(result);
    }
    public void testPowerOfFour() {

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
}
