/*
 * Author: Kartik Gola
 * Date: 16/06/20, 10:30 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package practice.leetcode;

public class ValidIpAddress {

    boolean containsValidChars(String subIp, boolean ipv4) {
        if ( ipv4 ) {
            for ( int i = 0; i < subIp.length(); ++i ) {
                int j = subIp.charAt(i);
                if ( j < '0' || j > '9' )
                    return false;
            }
        } else {
            for ( int i = 0; i < subIp.length(); ++i ) {
                int j = subIp.charAt(i);
                if ( !(( j >= '0' && j <= '9' ) || ( j >= 'a' && j <= 'f')) )
                    return false;
            }
        }
        return true;
    }

    boolean hasValidFormat(String subIp, boolean ipv4) {
        if ( subIp.isEmpty() )
            return false;
        try {
            int val = Integer.parseInt(subIp, ipv4 ? 10 : 16);
            if ( ipv4 && ( subIp.length() > 3 || val < 0 || val > 255 || (subIp.length() > 1 && subIp.startsWith("0"))) ) {
                return false;
            } else if ( !ipv4 && ( subIp.length() > 4 || val < 0 || val > 65535 ) ) {
                return false;
            }
        } catch ( Exception e ) {
            return false;
        }
        return true;
    }

    public String validIPAddress(String IP) {
        IP = IP.toLowerCase();
        boolean hasDot = IP.indexOf('.') >= 0;
        boolean hasColon = IP.indexOf(':') >= 0;
        if ( hasDot && hasColon )
            return "Neither";

        int count = 0, i = 0;
        for ( int j = 0; j < IP.length(); ++j ) {
            if ( IP.charAt(j) == '.' || IP.charAt(j) == ':' || j == IP.length() - 1 ) {
                String str = IP.substring(i, j == IP.length() - 1 ? IP.length() : j);
                if ( containsValidChars(str, hasDot) && hasValidFormat(str, hasDot) ) {
                    count++;
                    i = j + 1;
                }
                else break;
            }
        }

        if ( hasDot && count == 4 ) return "IPv4";
        if ( hasColon && count == 8 ) return "IPv6";

        return "Neither";
    }

}
