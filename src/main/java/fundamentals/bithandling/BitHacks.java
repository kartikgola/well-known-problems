/*
 * Author: Kartik Gola
 * Date: 10/4/21, 5:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package fundamentals.bithandling;

public class BitHacks {

    public int getBitAt(int num, int i) {
        return num & (1 << i);
    }

    public int setBitAt(int num, int i) {
        return num | (1 << i);
    }

    public int clearBitAt(int num, int i) {
        return num & ~(1 << i);
    }

    // Brian Kernighan's algorithm
    // http://graphics.stanford.edu/~seander/bithacks.html#CountBitsSetKernighan
    // Time complexity - O(K), where K is the number of set bits in num
    public int countSetBits(int num) {
        int count = 0;
        while (num > 0) {
            // AND operation with num and (num-1) always sets off right-most one-bit
            num &= (num-1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        // Stored as 00000000000000000000000000000111
        // However, o/p is just 111 since leading zeros (no matter how many they are) are never printed
        // This is binary representation of 7
        String binary7 = Integer.toBinaryString(7);
        System.out.printf("7 in binary is %s \n", binary7);

        // Stored as 11111111111111111111111111111001
        // This is 2's complement representation (~n+1) of absolute value (7)
        String binaryMinus7 = Integer.toBinaryString(-7);
        // so, it should be equal to ~7+1
        String binaryMinus7Internal = Integer.toBinaryString(~7 + 1);
        System.out.printf("-7 in binary is %s \n", binaryMinus7);
        System.out.printf("-7 is equal to ~7+1 ? %b \n", binaryMinus7.equals(binaryMinus7Internal));


        // Integer values
        System.out.printf("Max int value = %d \n", Integer.MAX_VALUE);
        System.out.printf("Max int value in binary = %s \n", Integer.toBinaryString(Integer.MAX_VALUE));
        // Max int value is 7f ff ff ff since leading 1-bit is reserved for sign
        System.out.printf("Max int value in binary = %s \n", Integer.toHexString(Integer.MAX_VALUE));
        System.out.printf("Min int value = %d \n", Integer.MIN_VALUE);
        System.out.printf("Min int value in binary = %s \n", Integer.toBinaryString(Integer.MIN_VALUE));
        // Min int value is 80 00 00 00 since leading 1-bit is reserved for sign
        System.out.printf("Min int value in binary = %s \n", Integer.toHexString(Integer.MIN_VALUE));
    }
}
