package mahergamal.codekata2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public abstract class AbstractBinarySearchTests {
    
    BinarySearch search = null;
    int[] numberList = new int[] { 0, 1, 3, 4, 6, 10, 23, 29, 44, 69, 102, 306, 545 };
    int infoundableTarget = 20;
    
    @Before
    public abstract void setup();
    
    @Test
    public void shouldSatisfyTheCodeKataTests() {
        assertEquals(-1, search.find(new int[] {}, 3));
        assertEquals(-1, search.find(new int[] { 1 }, 3));
        assertEquals(0, search.find(new int[] { 1 }, 1));
        
        assertEquals(0, search.find(new int[] { 1, 3, 5 }, 1));
        assertEquals(1, search.find(new int[] { 1, 3, 5 }, 3));
        assertEquals(2, search.find(new int[] { 1, 3, 5 }, 5));
        assertEquals(-1, search.find(new int[] { 1, 3, 5 }, 0));
        assertEquals(-1, search.find(new int[] { 1, 3, 5 }, 2));
        assertEquals(-1, search.find(new int[] { 1, 3, 5 }, 4));
        assertEquals(-1, search.find(new int[] { 1, 3, 5 }, 6));
        
        assertEquals(0, search.find(new int[] { 1, 3, 5, 7 }, 1));
        assertEquals(1, search.find(new int[] { 1, 3, 5, 7 }, 3));
        assertEquals(2, search.find(new int[] { 1, 3, 5, 7 }, 5));
        assertEquals(3, search.find(new int[] { 1, 3, 5, 7 }, 7));
        assertEquals(-1, search.find(new int[] { 1, 3, 5, 7 }, 0));
        assertEquals(-1, search.find(new int[] { 1, 3, 5, 7 }, 2));
        assertEquals(-1, search.find(new int[] { 1, 3, 5, 7 }, 4));
        assertEquals(-1, search.find(new int[] { 1, 3, 5, 7 }, 6));
        assertEquals(-1, search.find(new int[] { 1, 3, 5, 7 }, 8));
    }
    
    @Test
    public void shouldFindMiddleTarget() {
        int index = search.find(numberList, 23);
        assertEquals(6, index);
    }
    
    @Test
    public void shouldFindFirstTarget() {
        int index = search.find(numberList, 0);
        assertEquals(0, index);
    }
    
    @Test
    public void shouldFindLastTarget() {
        int index = search.find(numberList, 545);
        assertEquals(12, index);
    }
    
    @Test
    public void shouldFindTargetInUpperSlice() {
        int index = search.find(numberList, 69);
        assertEquals(9, index);
    }
    
    @Test
    public void shouldFindTargetInLowerSlice() {
        int index = search.find(numberList, 3);
        assertEquals(2, index);
    }
    
    @Test
    public void shouldReturnNegativeOneIfTargetDoesntExist() {
        int index = search.find(numberList, infoundableTarget);
        assertEquals(-1, index);
    }
}
