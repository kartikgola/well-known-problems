package leetcode;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

class NumberOfDiceRollsWithTargetSumTest {

    @Test
    void numRollsToTarget() {
        NumberOfDiceRollsWithTargetSum nodr = new NumberOfDiceRollsWithTargetSum();
//        assertEquals(35, nodr.numRollsToTarget(5, 5, 8));
        assertEquals(35, nodr.numRollsToTarget(4, 5, 7));
    }
}