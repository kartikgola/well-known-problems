/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package geeksforgeeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RotateTwice {

    public void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        String b = reader.readLine();

        final String rightRotate = b.substring(b.length() - 2).concat(b.substring(0, b.length() - 2));
        final String leftRotate = b.substring(2).concat(b.substring(0, 2));

        if ( leftRotate.equals(a) || rightRotate.equals(a) ) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
