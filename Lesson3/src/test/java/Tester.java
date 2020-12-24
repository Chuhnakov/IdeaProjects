import org.junit.Assert;
import org.junit.Test;
import ru.chuhnakov.Solution;

public class Tester {
    Solution s = new Solution();

    @Test
    public void testBeautifulArray() {

        boolean res = false;

//        res = isBeautifulArray(s.beautifulArray(3));
//        Assert.assertTrue(res);
//
//        res = isBeautifulArray(s.beautifulArray(5));
//        Assert.assertTrue(res);
//
//        res = isBeautifulArray(s.beautifulArray(6));
//        Assert.assertTrue(res);
//
//        res = isBeautifulArray(s.beautifulArray(10));
//        Assert.assertTrue(res);

//        res = isBeautifulArray(s.beautifulArray(11));
//        Assert.assertTrue(res);
        res = isBeautifulArray(new int[]{10, 8, 6, 4, 2
        });
        Assert.assertTrue(res);
    }
//6, 2, 10,4, 8,
    //1, 9, 11, 5, 3, 7, 2, 10, 6, 8, 4
    //1, 9, 5, 7, 3, 11, 4, 8, 2, 10, 6
    //1, 9, 5, 7, 3, 11, 2, 10, 6, 8, 4
    //1, 9, 5, 7, 6, 11, 2, 10, 6, 8, 4
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
        for (int index = 1; index < array.length - 1; index++)
            for (int i = 0; i < index; i++)
                for (int j = array.length - 1; j > index; j--)
                    if (array[i] + array[j] == array[index] * 2)
                        return false;


        return true;
    }

}
