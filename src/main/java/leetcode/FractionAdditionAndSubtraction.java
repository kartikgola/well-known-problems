/*
 * Author: Kartik Gola
 * Date: 21/01/2021, 01:00
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/fraction-addition-and-subtraction/
 */

package leetcode;

public class FractionAdditionAndSubtraction {

    static class MathUtils {

        static int gcd(int a, int b) {
            if (a == 0)
                return b;
            else if (b == 0)
                return a;
            return Math.abs(gcd(b % a, a));
        }

        static int lcm(int a, int b) {
            final int gcdVal = gcd(a, b);
            return gcdVal == 0 ? 0 : (a * b) / gcdVal;
        }
    }

    class Fraction {
        int num, den;

        Fraction(int n, int d) {
            num = n;
            den = d;
            if (n == 0) { den = 0; }
            if (den < 0) {
                num = -1 * num;
                den = -1 * den;
            }
            reduce();
        }

        Fraction(int n) {
            num = n;
            den = 1;
            if (num == 0) { den = 0; }
            reduce();
        }

        Fraction reduce() {
            int gcdVal = 0;
            while ((gcdVal = MathUtils.gcd(num, den)) > 1 && num != 0 && den != 0) {
                num /= gcdVal;
                den /= gcdVal;
            }
            return this;
        }

        Fraction add(Fraction f) {
            if (num == 0)
                return new Fraction(f.num, f.den);
            if (f.num == 0)
                return new Fraction(num, den);
            final int lcm = MathUtils.lcm(den, f.den);
            int newNum = num * (lcm/den) + f.num * (lcm/f.den);
            return new Fraction(newNum, lcm);
        }

        Fraction sub(Fraction f) {
            if (num == 0)
                return new Fraction(-1 * f.num, f.den);
            if (f.num == 0)
                return new Fraction(num, den);
            final int lcm = MathUtils.lcm(den, f.den);
            int newNum = num * (lcm/den) - f.num * (lcm/f.den);
            return new Fraction(newNum, lcm);
        }

        public String toString() {
            return num + "/" + den;
        }

    }

    public String fractionAddition(String exp) {
        Fraction f = new Fraction(0);
        StringBuilder num = new StringBuilder();
        StringBuilder den = new StringBuilder();
        if (!exp.startsWith("-"))
            exp = "+" + exp;
        Character sign = null;
        boolean div = false;

        for (int i = 0; i < exp.length(); ++i) {
            char ch = exp.charAt(i);
            if (ch == '-' || ch == '+') {
                if (num.length() > 0) {
                    Fraction g = new Fraction(Integer.parseInt(num.toString()), Integer.parseInt(den.toString()));
                    if (sign == '-') {
                        f = f.sub(g);
                    } else {
                        f = f.add(g);
                    }
                    num.delete(0, num.length());
                    den.delete(0, den.length());
                }
                sign = ch;
                div = false;
            } else if (ch == '/') {
                div = true;
            } else {
                if (!div) num.append(ch);
                else den.append(ch);
            }
        }

        if (num.length() > 0) {
            Fraction g = new Fraction(Integer.parseInt(num.toString()), Integer.parseInt(den.toString()));
            if (sign == '-') {
                f = f.sub(g);
            } else {
                f = f.add(g);
            }
        }

        return f.toString().equals("0/0") ? "0/1" : f.toString();
    }
}



