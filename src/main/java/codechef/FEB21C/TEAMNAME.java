/*
 * Author: Kartik Gola
 * Date: 10/02/2021, 14:20
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://www.codechef.com/FEB21C/problems/TEAMNAME
 */

package codechef.FEB21C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class TEAMNAME {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            Map<String, boolean[]> map = new HashMap<>();
            while (st.hasMoreTokens()) {
                String word = st.nextToken();
                String suffix = word.substring(1);
                map.putIfAbsent(suffix, new boolean[26]);
                map.get(suffix)[word.charAt(0) - 'a'] = true;
            }

            long count = 0;
            List<boolean[]> vals = new ArrayList<>(map.values());
            for (int i = 0; i < vals.size(); ++i) {
                for (int j = i+1; j < vals.size(); ++j) {
                    int first = 0, second = 0;
                    for (int k = 0; k < 26; ++k) {
                        // Prefix should be present only in one of the suffixes
                        if (!(vals.get(i)[k] && vals.get(j)[k])) {
                            first += vals.get(i)[k] ? 1 : 0;
                            second += vals.get(j)[k] ? 1 : 0;
                        }
                    }
                    count += first * second * 2;
                }
            }

            System.out.println(count);
        }
    }
}
