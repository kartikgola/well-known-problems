package util;

public class Utils {

    public static long PRIME_MOD = 1000_000_007L;

    public static long fastPow(long base, long exp) {
        long res = 1;
        while ( exp > 0 ) {
            if ( exp % 2 == 0 ) {
                base = (base * base) % PRIME_MOD;
                exp = exp / 2;
            } else {
                res = (res * base) % PRIME_MOD;
                base = (base * base) % PRIME_MOD;
                exp = exp / 2;
            }
        }
        return res;
    }
}
