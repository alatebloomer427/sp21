package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> list = new AListNoResizing<>();
        BuggyAList<Integer> listBug = new BuggyAList<>();

        list.addLast(4);
        list.addLast(5);
        list.addLast(6);

        listBug.addLast(4);
        listBug.addLast(5);
        listBug.addLast(6);

        assertEquals(list.size(), listBug.size());

        assertEquals(list.removeLast(), listBug.removeLast());
        assertEquals(list.removeLast(), listBug.removeLast());
        assertEquals(list.removeLast(), listBug.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
                assertEquals(L.getLast(), B.getLast());
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int sizeB = B.size();
                assertEquals(size, sizeB);
            } else if (operationNumber == 2) {
                // getLast
                if (L.size() == 0) {
                    continue;
                }
                int lastNum = L.getLast();
                int lastNumB = B.getLast();
                assertEquals(lastNum, lastNumB);
            } else {
                // removeLast
                if (L.size() == 0) {
                    continue;
                }
                int removedNum = L.removeLast();
                int removedNumB = B.removeLast();
                assertEquals(removedNum, removedNumB);
            }
        }
    }
}
