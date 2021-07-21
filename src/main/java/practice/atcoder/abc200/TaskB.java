package practice.atcoder.abc200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class TaskB {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inp = br.readLine().split(" ");
        BigInteger n = new BigInteger(inp[0]);
        int k = Integer.parseInt(inp[1]);
        BigInteger two = new BigInteger("200");

        while (k-- > 0) {
            if (n.mod(two).equals(BigInteger.ZERO)) {
                n = n.divide(two);
            } else {
                n = new BigInteger(n + "200");
            }
        }

        System.out.println(n);
    }
}
