/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | rattl.io
 */

package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Lapin {

    private HashMap<Character, Integer> getOccuranceMap(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); ++i) {
            final char key = str.charAt(i);
            if ( map.containsKey(key) ) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        return map;
    }

    public void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        while ( t-- > 0 ) {
            String str = reader.readLine();
            final boolean isEvenLength = str.length() % 2 == 0;
            HashMap<Character, Integer> leftMap = getOccuranceMap(str.substring(0, str.length() / 2));
            HashMap<Character, Integer> rightMap = getOccuranceMap(str.substring(isEvenLength ? str.length() / 2 : (str.length() / 2) + 1));

            boolean isLapin = true;
            for (HashMap.Entry<Character, Integer> e: leftMap.entrySet()) {
                if ( !rightMap.containsKey(e.getKey()) || !rightMap.get(e.getKey()).equals(e.getValue()) ) {
                    isLapin = false;
                    break;
                }
            }

            System.out.println(isLapin ? "YES" : "NO");
        }
    }
}
