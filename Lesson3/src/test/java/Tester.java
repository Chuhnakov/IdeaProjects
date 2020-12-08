import org.junit.Assert;
import org.junit.Test;
import ru.chuhnakov.Solution;

public class Tester {
    Solution s = new Solution();

    @Test
    public void testBeautifulArray() {

        boolean res = false;

        res = isBeautifulArray(s.beautifulArray(3));
        Assert.assertTrue(res);

        res = isBeautifulArray(s.beautifulArray(5));
        Assert.assertTrue(res);

        res = isBeautifulArray(s.beautifulArray(6));
        Assert.assertTrue(res);

        res = isBeautifulArray(s.beautifulArray(10));
        Assert.assertTrue(res);

        res = isBeautifulArray(s.beautifulArray(11));
        Assert.assertTrue(res);
    }

    @Test
    public void testMinPatches() {
        int resMinPatches = -1;
        int assertRes = -1;

        resMinPatches = s.minPatches(new int[]{1, 5, 10}, 20);
        assertRes = 2;
        Assert.assertEquals(resMinPatches, assertRes);

        resMinPatches = s.minPatches(new int[]{1, 3}, 6);
        assertRes = 1;
        Assert.assertEquals(resMinPatches, assertRes);

        resMinPatches = s.minPatches(new int[]{1, 2, 2}, 5);
        assertRes = 0;
        Assert.assertEquals(resMinPatches, assertRes);

    }

    private boolean isBeautifulArray(int[] array) {
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i - 1] + array[i + 1] == array[i] * 2)
                return false;
        }
        return true;
    }

}
