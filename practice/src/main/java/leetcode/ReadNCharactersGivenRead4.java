/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */
package leetcode;

public class ReadNCharactersGivenRead4 {

    // The read4 API is defined in the parent class Reader4.
    int read4(char[] buf4) { return -1; }

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        if ( n <= 0 )
            return 0;

        char[] buf4 = new char[4];
        int write = 0, read = read4(buf4);

        while ( write < n && read > 0 ) {
            for ( int i = 0; i < read && write < n; ++i ) {
                buf[write++] = buf4[i];
            }
            buf4 = new char[4];
            read = read4(buf4);
        }

        return write;
    }
}
