/*
 * Author: Kartik Gola
 * Date: 4/17/21, 12:34 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL: https://atcoder.jp/contests/jsc2021
 */

package atcoder.jsc2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskA {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        double x = Double.parseDouble(inputs[0]);
        double y = Double.parseDouble(inputs[1]);
        double z = Double.parseDouble(inputs[2]);

        double w = y / x * z;
        if (Math.floor(w) == w)
            System.out.println((int)(w - 1));
        else
            System.out.println((int)Math.floor(w));
    }
}
