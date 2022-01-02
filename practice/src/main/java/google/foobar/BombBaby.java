/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package google.foobar;

import java.math.BigInteger;

public class BombBaby {

    public static String solution(String x, String y) {
        if ( x.equals("1") && y.equals("1") )
            return "0";

        BigInteger m = new BigInteger(x);
        BigInteger f = new BigInteger(y);

        if ( m.compareTo(BigInteger.ZERO) <= 0 || f.compareTo(BigInteger.ZERO) <= 0 ) {
            return "impossible";
        }

        BigInteger steps = BigInteger.ZERO;
        int cmp = -1;

        // Algo
        // Go back from (m, f) -> .... -> (1, 1)
        // States where m = f (except 1,1) are not possible
        while ( true ) {
            cmp = m.compareTo(f);
            if ( cmp < 0 ) { // m < f
                steps = steps.add(f.divide(m));
                f = f.mod(m);
                if ( f.equals(BigInteger.ZERO) ) {
                    if ( m.equals(BigInteger.ONE) ) {
                        steps = steps.subtract(BigInteger.ONE);
                        break;
                    } else {
                        return "impossible";
                    }
                }
            } else if ( cmp > 0 ) { // m > f
                steps = steps.add(m.divide(f));
                m = m.mod(f);
                if ( m.equals(BigInteger.ZERO) ) {
                    if ( f.equals(BigInteger.ONE) ) {
                        steps = steps.subtract(BigInteger.ONE);
                        break;
                    } else {
                        return "impossible";
                    }
                }
            } else {
                return "impossible";
            }
        }

        return steps.toString();
    }
}
