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
        boolean pos = exp >= 0;
        long res = 1;
        while (exp != 0) {
            if (exp % 2 == 0) {
                base *= base;
                exp /= 2;
            } else {
                res *= base;
                exp = exp + (exp > 0 ? -1 : 1);
            }
        }
        return pos ? res : 1/res;
    }

    /**
     * Performs fast exponentiation of a given base to the power exp
     * @param base
     * @param exp
     * @return double value of base to the power exp
     */
    public static double fastPow(double base, double exp) {
        boolean pos = exp >= 0;
        double res = 1.0;
        while (exp != 0) {
            if (exp % 2 == 0) {
                base *= base;
                exp /= 2;
            } else {
                res *= base;
                exp = exp + (exp > 0 ? -1 : 1);
            }
        }
        return pos ? res : 1/res;
    }

    /**
     * Returns seive of prime numbers upto (not including) the given number
     * False values indicate primality
     * True values indicates non-primality
     * @param number
     * @return Returns seive of prime numbers upto (not including) the given number
     */
    public static boolean[] primeNumbersSeive(int number) {
        boolean[] seive = new boolean[number];
        if ( number > 2 ) {
            for ( int num = 2; num * num <= number - 1; ++num ) {
                if ( !seive[num] ) {
                    for ( int mult = num * 2; mult < seive.length; mult += num ) {
                        seive[mult] = true;
                    }
                }
            }
        }
        return seive;
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
        if (number <= 0)
            return new ArrayList<>();

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
        if (pFactors.isEmpty()) {
            pFactors.add(number);
        }
        return pFactors;
    }

}
