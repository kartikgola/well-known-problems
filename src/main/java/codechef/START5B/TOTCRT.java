/*
 * Author: Kartik Gola
 * Date: 6/27/21, 4:21 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL:
 */

package codechef.START5B;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static util.IOUtils.*;

public class TOTCRT {

    public void solve() throws Exception {
        int t = nextInt();
        while (t-- > 0) {
            int n = nextInt() * 3;
            Map<String, Long> map = new HashMap<>();
            while (n-- > 0) {
                String code = nextString();
                Long val = Long.parseLong(nextString());
                map.put(code, map.getOrDefault(code, 0L) + val);
            }
            List<Long> al = new ArrayList<>(map.values());
            Collections.sort(al);

            for (long num: al)
                System.out.print(num + " ");
            System.out.println();
        }
    }
}
