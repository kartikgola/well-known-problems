/*
 * Author: Kartik Gola
 * Date: 4/17/21, 12:33 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL:
 */

package google.foobar;

public class Fraction {
    long n;
    long d;

    public Fraction(long n) {
        if ( n == 0 ) {
            this.n = 0;
            this.d = 0;
        } else {
            this.n = n;
            this.d = 1;
        }
    }

    public Fraction(long n, long d) {
        if ( n == 0 || d == 0 ) {
            this.n = 0;
            this.d = 0;
        } else {
            if ( n < 0 && d < 0 ) {
                this.n = Math.abs(n);
                this.d = Math.abs(d);
            } else if ( n < 0 ) {
                this.n = n;
                this.d = d;
            } else if ( d < 0 ) {
                this.n = -1 * n;
                this.d = Math.abs(d);
            } else {
                this.n = n;
                this.d = d;
            }
            this.factorize();
        }
    }

    public static long gcd(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if ( a == 0 ) {
            return b;
        } return gcd( b % a, a );
    }

    public static long lcm(long a, long b) {
        if ( a == 0 || b == 0 ) {
            return 0;
        } else {
            return ( a * b ) / gcd(a, b);
        }
    }

    Fraction add(Fraction f) {
        if ( this.n == 0 && f.n == 0 ) {
            return new Fraction(0);
        } else if ( this.n == 0 ) {
            return new Fraction(f.n, f.d);
        } else if ( f.n == 0 ) {
            return new Fraction(this.n, this.d);
        } else {
            long denom = (this.d * f.d) / gcd(this.d, f.d);
            long numer = (this.n * ( denom / this.d )) + (f.n * ( denom / f.d ));
            return new Fraction(numer, denom).factorize();
        }
    }

    Fraction subtract(Fraction f) {
        if ( this.n == 0 && f.n == 0 ) {
            return new Fraction(0);
        } else if ( this.n == 0 ) {
            return new Fraction(-1 * f.n, f.d);
        } else if ( f.n == 0 ) {
            return new Fraction(this.n, this.d);
        } else {
            long denom = (this.d * f.d) / gcd(this.d, f.d);
            long numer = (this.n * ( denom / this.d )) - (f.n * ( denom / f.d ));
            return new Fraction(numer, denom).factorize();
        }
    }

    Fraction multiply(Fraction f) {
        if ( this.n == 0 || f.n == 0 ) {
            return new Fraction(0, 0);
        }
        return new Fraction(this.n * f.n, this.d * f.d).factorize();
    }

    Fraction divide(Fraction f) {
        if ( f.n != 0 && this.n != 0 ) {
            return new Fraction(this.n * f.d, this.d * f.n).factorize();
        }
        return new Fraction(0);
    }

    Fraction factorize() {
        long gcd = gcd(Math.abs(this.n), Math.abs(this.d));
        if ( gcd != 0 ) {
            this.n /= gcd;
            this.d /= gcd;
        }
        return this;
    }

    @Override
    public String toString() {
        return n + "/" + d;
    }
}