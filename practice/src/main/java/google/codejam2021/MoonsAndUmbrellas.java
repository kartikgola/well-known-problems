/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package google.codejam2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MoonsAndUmbrellas {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int _t = 1; _t <= t; ++_t) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            int[] dp = new int[s.length()];
            Map<String, Integer> map = new HashMap<String, Integer>(){{
                put("CJ", x); put("JC", y);
                put("J?C", y); put("J?J", 0);
                put("C?C", 0); put("C?J", x);
            }};

            for (int i = s.length() - 2; i > -1; --i) {
                String window = s.substring(i, i+2);
                if (window.equals("CJ")) {
                    dp[i] = x + dp[i+1];
                } else if (window.equals("JC")) {
                    dp[i] = y + dp[i+1];
                } else if (window.equals("JJ") || window.equals("CC") || window.equals("??")) {
                    dp[i] = dp[i+1];
                } else if (window.charAt(1) == '?') {
                    // C? or J?
                    dp[i] =  dp[i+1];
                } else {
                    if (i > 0) {
                        if (s.charAt(i-1) != '?') {
                            // a?s
                            dp[i] = dp[i+1] + map.get(s.charAt(i-1) + window);
                            dp[i-1] = dp[i];
                            --i;
                        } else {
                            // ??s
                            dp[i] = dp[i+1];
                        }
                    } else {
                        // ?C or ?J
                        dp[i] = dp[i+1];
                    }
                }
            }

            System.out.printf("Case #%d: %d\n", _t, dp[0]);
        }
    }
}
