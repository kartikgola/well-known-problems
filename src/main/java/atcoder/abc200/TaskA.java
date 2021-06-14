package atcoder.abc200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskA {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n % 100 == 0)
            System.out.println(n / 100);
        else
            System.out.println((n / 100) + 1);
    }
}
