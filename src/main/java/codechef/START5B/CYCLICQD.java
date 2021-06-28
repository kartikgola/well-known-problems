/*
 * Author: Kartik Gola
 * Date: 6/27/21, 4:00 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL:
 */

package codechef.START5B;

import util.IOUtils;
import java.io.IOException;

public class CYCLICQD {

    public void solve() throws Exception {
        int t = IOUtils.nextInt();
        while (t-- > 0) {
            int a = IOUtils.nextInt(),
                b = IOUtils.nextInt(),
                c = IOUtils.nextInt(),
                d = IOUtils.nextInt();

            if (a+c == 180 && b+d == 180)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
