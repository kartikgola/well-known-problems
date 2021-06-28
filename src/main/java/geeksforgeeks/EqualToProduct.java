/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package geeksforgeeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class EqualToProduct {

    public void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        while ( t-- > 0 ) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            int n = Integer.parseInt(tokenizer.nextToken());
            int x = Integer.parseInt(tokenizer.nextToken());

            tokenizer = new StringTokenizer(reader.readLine(), " ");
            Set<Integer> set = new HashSet<>();
            List<Integer> l = new ArrayList<>(n);

            while ( tokenizer.hasMoreTokens() ) {
                l.add(Integer.parseInt(tokenizer.nextToken()));
            }

            if ( x == 0 ) {
                // Array should contain a 0
                System.out.println(l.indexOf(0) > -1 ? "Yes" : "No");
            } else {
                boolean containsX = false;
                for ( Integer li : l ) {
                    if ( li != 0 ) {
                        if ( set.contains(li) ) {
                            containsX = true;
                            break;
                        } else {
                            set.add(x / li);
                        }
                    }
                }
                System.out.println(containsX ? "Yes" : "No");
            }
        }
    }
}