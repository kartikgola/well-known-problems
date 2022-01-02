/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package codechef.FEB21C;

import static util.IOUtils.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FROGS {

    public static void main(String[] args) throws Exception {
        int t = nextInt();
        while (t-- > 0) {
            int n = nextInt();
            Map<Integer, List<Integer>> map = new HashMap<>();
            int[] W = nextInts(n);
            int[] L = nextInts(n);

            // Create map of {weight=[Initial Position, Jump distance]}
            int pos = 1;
            for (int i = 0; i < n; ++i)
                map.put(W[i], Arrays.asList(pos++, L[i]));

            int jumps = 0;
            for (int w = 2; w <= n; ++w) {
                int dist = map.get(w).get(0) - map.get(w-1).get(0);
                if (dist <= 0) {
                    int jumpsNeeded = dist == 0 ? 1 : (int) Math.ceil((-1.0 * dist + 1) / map.get(w).get(1));
                    int finalPos = map.get(w).get(0) + jumpsNeeded * map.get(w).get(1);
                    map.get(w).set(0, finalPos);
                    jumps += jumpsNeeded;
                }
            }
            System.out.println(jumps);
        }
    }
}
