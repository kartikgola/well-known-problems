/*
 * Author: Kartik Gola
 * Date: 1/15/22, 10:34 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package string;

public class StringFormatTest {

    public static void main(String[] args) {
        String str = String.format("%d year has %d months and %d days", 1, 12, 365);
        System.out.println(str);

        str = String.format("%d divided by %d is %.1f", 1, 3, 1/3.0);
        System.out.println(str);
    }
}
