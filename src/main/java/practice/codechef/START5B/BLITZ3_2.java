/*
 * Author: Kartik Gola
 * Date: 6/27/21, 4:06 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL:
 */

package practice.codechef.START5B;

import static util.IOUtils.*;

public class BLITZ3_2 {

    public void solve() throws Exception {
        int t = nextInt();
        while (t-- > 0) {
            int n = nextInt(),
                a = nextInt(),
                b = nextInt();

            int total = 2*(180+n);
            int left = a+b;
            System.out.println(total - left);
        }
    }
}
