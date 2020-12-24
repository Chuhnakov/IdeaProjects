import Chuhnakov.ru.Solution;
import org.junit.Assert;
import org.junit.Test;

public class Tester {
    Solution s = new Solution();

    @Test
    public void isLongestCommonPrefix() {
        Assert.assertEquals(s.longestCommonPrefix(new String[]{"flight", "flow", "flower"}), "fl");

        Assert.assertEquals(s.longestCommonPrefix(new String[]{"flam", "flab", "flight", "flow", "flower"}), "fl");

        Assert.assertEquals(s.longestCommonPrefix(new String[]{"dog", "racecar", "car"}), "");
    }
}
