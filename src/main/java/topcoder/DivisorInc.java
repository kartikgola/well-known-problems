package topcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DivisorInc {

    private ArrayList<Integer> findFactors(int number) {
        ArrayList<Integer> list = new ArrayList<>();
        final double NUMBER_SQRT = Math.floor(Math.sqrt(number));
        for ( int num = 2; num <= NUMBER_SQRT; ++num ) {
            if ( number % num  == 0 )
                list.add(num);
        }
        final int LIST_SIZE = list.size();
        for ( int i = LIST_SIZE - 1; i >= 0; --i ) {
            list.add( number / list.get(i) );
        }
        return list;
    }

    public void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());

        int current = n;
        int operations = 0;
        while ( current != m ) {
            ArrayList<Integer> factors = this.findFactors(current);
            for ( int i = factors.size() - 1; i >= 0; --i ) {
                if ( factors.get(i) + current <= m ) {
                    System.out.print(current + "->");
                    current += factors.get(i);
                    ++operations;
                    break;
                }
            }
        }

        System.out.println("\n" + operations);
    }
}
