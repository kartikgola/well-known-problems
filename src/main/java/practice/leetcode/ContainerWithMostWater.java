/*
 * Author: Kartik Gola
 * Date: 11/28/21, 11:25 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int begin = 0;
        int end = height.length - 1;
        int maxWater = 0;

        while (begin < end) {
            maxWater = Math.max(maxWater, (end - begin) * Math.min(height[begin], height[end]));
            if (height[begin] <= height[end])
                begin++;
            else
                end--;
        }

        return maxWater;
    }
}
