/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;

public class ATM {

    public void solve() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int x = Integer.parseInt(tokenizer.nextToken());
        float y = Float.parseFloat(tokenizer.nextToken());

        if ( (x + 0.5f) <= y && x % 5 == 0 )
            y = y - (x + 0.5f);

        System.out.printf(Locale.US, "%.2f", y);
    }
}
