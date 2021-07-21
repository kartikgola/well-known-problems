/*
 * Author: Kartik Gola
 * Date: 6/3/21, 4:48 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
 */

package practice.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MaximumAreaOfAPieceOfCake {

    // O(log(n)) code
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        long mh = h-horizontalCuts[horizontalCuts.length-1]; // max height
        long mw = w-verticalCuts[verticalCuts.length-1]; // max width

        for (int i = 0; i < horizontalCuts.length; i++)
            mh = Math.max(mh, horizontalCuts[i] - (i == 0 ? 0 : horizontalCuts[i-1]));

        for (int i = 0; i < verticalCuts.length; i++)
            mw = Math.max(mw, verticalCuts[i] - (i == 0 ? 0 : verticalCuts[i-1]));

        return (int)((mh * mw) % 1000_000_007);
    }

    // O(log(n)) Golf code
    public int maxArea2(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        return (int)(((long)
                IntStream.concat(Stream.of(h).mapToInt(Integer::intValue), Arrays.stream(horizontalCuts))
                .sorted()
                .mapToObj(e -> new int[]{e, 0})
                .reduce(new int[]{0, 0}, (maxHeight, elem) -> new int[]{Math.max(maxHeight[0], elem[0] - maxHeight[1]), elem[0]})[0]
                *
                IntStream.concat(Stream.of(w).mapToInt(Integer::intValue), Arrays.stream(verticalCuts))
                .sorted()
                .mapToObj(e -> new int[]{e, 0})
                .reduce(new int[]{0, 0}, (maxWidth, elem) -> new int[]{Math.max(maxWidth[0], elem[0] - maxWidth[1]), elem[0]})[0]) % 1000_000_007
        );
    }
}
