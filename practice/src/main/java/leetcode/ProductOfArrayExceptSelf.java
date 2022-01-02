/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        final int n = nums.length;
        int[] prefixProd = new int[n];
        int[] postfixProd = new int[n];
        int[] result = new int[n];

        int preProduct = 1;
        for ( int i = 0; i < n; ++i ) {
            prefixProd[i] = nums[i] * preProduct;
            preProduct = prefixProd[i];
        }

        int postProduct = 1;
        for ( int i = n - 1; i > -1; --i ) {
            postfixProd[i] = nums[i] * postProduct;
            postProduct = postfixProd[i];
        }

        result[0] = postfixProd[1];
        result[n - 1] = prefixProd[(n - 1) - 1];
        for ( int i = 1; i < n - 1; ++i ) {
            result[i] = prefixProd[i - 1] * postfixProd[i + 1];
        }

        return result;
    }
}