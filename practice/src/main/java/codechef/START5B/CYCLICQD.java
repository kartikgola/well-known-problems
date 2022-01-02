/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package codechef.START5B;

import util.IOUtils;

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
