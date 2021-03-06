/*
 * Author: Kartik Gola
 * Date: 12/04/2021, 20:23
 * Copyright (c) 2021 | https://kartikgola.com
 */

package fundamentals.strings;

import java.util.StringJoiner;

public class StringJoinerTest {

    public static void main(String[] args) {
        // Like StringBuilder with added support for delimiter, prefix, suffix
        StringJoiner sj = new StringJoiner(", ", "{", "}");
        sj.add("a");
        sj.add("b");
        sj.add("c");
        System.out.println(sj.toString()); // {a, b, c}

        sj = new StringJoiner("],[", "[", "]");
        sj.add("a");
        sj.add("b");
        sj.add("c");
        System.out.println(sj.toString()); // [a],[b],[c]

        // Edge cases are handled automatically :3
        sj = new StringJoiner("],[", "[", "]");
        System.out.println(sj.toString()); // []

        sj = new StringJoiner("],[", "[", "]");
        sj.setEmptyValue("EMPTY");
        System.out.println(sj.toString()); // EMPTY

        sj = new StringJoiner("],[", "[", "]");
        sj.setEmptyValue("EMPTY");
        sj.add("");
        System.out.println(sj.toString()); // []
    }
}
