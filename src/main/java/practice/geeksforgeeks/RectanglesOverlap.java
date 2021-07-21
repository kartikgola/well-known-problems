/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package practice.geeksforgeeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RectanglesOverlap {

    private class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        while ( t-- > 0 ) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            Point l1 = new Point(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));

            tokenizer = new StringTokenizer(reader.readLine(), " ");
            Point r1 = new Point(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));

            tokenizer = new StringTokenizer(reader.readLine(), " ");
            Point l2 = new Point(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));

            tokenizer = new StringTokenizer(reader.readLine(), " ");
            Point r2 = new Point(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));

            // Check if it is one of the four cases of non-overlapping
            if ( l1.x - r2.x > 0 || l2.x - r1.x > 0 || r2.y - l1.y > 0 || r1.y - l2.y > 0 ) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }
    }
}