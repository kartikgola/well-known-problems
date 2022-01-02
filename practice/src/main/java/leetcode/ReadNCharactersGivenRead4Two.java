/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */
package leetcode;

public class ReadNCharactersGivenRead4Two {

    // The read4 API is defined in the parent class Reader4.
    int read4(char[] buf4) { return -1; }

    // left (inc.) & right (exc.) pointers of p4
    int l = 0, r = 0;
    char[] p4 = new char[4];

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int i = 0;
        // get chars from prev buffer
        while (i < n && l < r) {
            buf[i++] = p4[l++];
        }
        // prev buffer consumed? reset l & r
        if (l == r)
            l = r = 0;
        while (i < n) {
            char[] buf4 = new char[4];
            int x = read4(buf4);
            if (x == 0)
                break;
            int j = 0;
            while (i < n && j < x) {
                buf[i++] = buf4[j++];
            }
            // put the extra chars in prev buffer
            if (j < x)
                r = x-j;
            while (j < x) {
                p4[l++] = buf4[j++];
            }
            // since we are in the while loop, it means p4 has already been consumed outside
            // so, we reset l to 0
            l = 0;
        }
        return i;
    }
}
