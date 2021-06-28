/*
 * Author: Kartik Gola
 * Date: 6/27/21, 4:44 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL:
 */

package codechef.START5B;

import java.io.IOException;
import java.util.*;

import static util.IOUtils.nextInt;
import static util.IOUtils.nextString;

public class SLPCYCLE {

    public void solve() throws Exception {
        int t = nextInt();
        while (t-- > 0) {
            int l = nextInt();
            int h = nextInt();
            String s = nextString();

            List<Integer> cont = new ArrayList<>();
            int p = -1;
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == '1' && p > -1) {
                    cont.add(i-p);
                    p = -1;
                } else if (s.charAt(i) == '0' && p == -1) {
                    p = i;
                }
            }
            if (p != -1)
                cont.add(s.length()-p);

            cont.sort(Collections.reverseOrder());
            int r = h;
            for (int i = 0; i < cont.size() && r > 0; ++i) {
                int v = cont.get(i);
                if (v >= r) {
                    r = 0;
                } else {
                    r = 2*(r-v);
                }
            }

            System.out.println(r == 0 ? "YES" : "NO");
        }
    }

    public static void main(String[] args) throws Exception {
        new SLPCYCLE().solve();
    }
}
