/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int begin = 0;
        int end = height.length - 1;
        int maxWater = 0;

        while (begin < end) {
            int waterWidth = end - begin;
            int waterHeight = Math.min(height[begin], height[end]);
            maxWater = Math.max(maxWater, waterWidth * waterHeight);

            if (height[begin] <= height[end])
                begin++; // inc begin, in the hope of getting better height
            else
                end--; // dec end, in the hope of getting better height
        }

        return maxWater;
    }
}
