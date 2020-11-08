/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package util;

import java.util.ArrayList;
import java.util.List;

public class MathUtils {

    /**
     * Performs fast exponentiation of a given base to the power exp
     * @param base
     * @param exp
     * @return long value of base to the power exp
     */
    public static long fastPow(long base, long exp) {
        final long PRIME_MOD = 1000_000_007L;
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
        while ( exp < 0 ) {
            if ( exp % 2 == 0 ) {
                base = (base * base) % PRIME_MOD;
                exp = exp / 2;
            } else {
                res = (res / base) % PRIME_MOD;
                base = (base * base) % PRIME_MOD;
                exp = exp / 2;
            }
        }
        return res;
    }

    /**
     * Returns list of all prime numbers upto (not including) the specified number
     * @param number
     * @return List of Integer of all prime numbers upto given number (exclusive)
     */
    public static List<Integer> primeNumbersUpto(int number) {
        List<Integer> primes = new ArrayList<>();
        if ( number > 2 ) {
            boolean[] seive = new boolean[number];
            for ( int num = 2; num < seive.length; ++num ) {
                if ( !seive[num] ) {
                    for ( int mult = num * 2; mult < seive.length; mult += num ) {
                        seive[mult] = true;
                    }
                }
            }
            for ( int num = 2; num < seive.length; ++num ) {
                if ( !seive[num] ) {
                    primes.add(num);
                }
            }
        }
        return primes;
    }

    /**
     * Returns all prime factors of the given number in an Integer List
     * @param number
     * @return List of Integer containing prime factorization of given number
     */
    public static List<Integer> primeFactors(int number) {
        List<Integer> pFactors = new ArrayList<>();
        List<Integer> primes = primeNumbersUpto((int) Math.sqrt(number) + 1);
        for ( Integer prime : primes ) {
            if ( number % prime == 0 ) {
                while ( number > 0 && number % prime == 0 ) {
                    pFactors.add(prime);
                    number = number / prime;
                }
            }
        }
        return pFactors;
    }

}
