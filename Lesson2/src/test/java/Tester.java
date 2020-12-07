import org.junit.Test;
import ru.chuhnakov.Solution;

import static junit.framework.Assert.*;

public class Tester {

    @Test
    public void AreaTest(){
        Solution s = new Solution();
        assertEquals(s.maxArea(new int[]{3, 5, 2, 4,10,9,6}),25);
        assertEquals(s.maxArea(new int[]{3, 9, 3, 4,7,2,12,6}),45);
        assertEquals(s.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}),49);
    }
}
