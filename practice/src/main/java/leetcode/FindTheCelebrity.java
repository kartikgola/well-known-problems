/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class FindTheCelebrity {

    // This method is provided by OJ
    public boolean knows(int i, int j) {
        return true;
    }

    public int findCelebrity(int n) {
        if (n == 0)
            return 0;

        // Since there is only 1 celebrity in the party if 'i' knows 'j'
        // 'i' cannot be the celebrity since he knows 'j'. So, our celebrity becomes 'j'
        int celebrity = 0;
        for (int i = 0; i < n; ++i) {
            if (knows(celebrity, i)) {
                celebrity = i;
            }
        }

        for (int i = 0; i < n; ++i) {
            // Check if everybody knows this celebrity
            // And that this celebrity does not know anybody else
            if (!knows(i, celebrity) || (celebrity != i && knows(celebrity, i))) {
                return -1;
            }
        }

        return celebrity;
    }
}
