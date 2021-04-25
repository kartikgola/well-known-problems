package atcoder.abc199;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TaskB {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> a = new ArrayList<>(n);
        List<Integer> b = new ArrayList<>(n);

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens())
            a.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens())
            b.add(Integer.parseInt(st.nextToken()));

        int x = a.get(0),
            y = b.get(0);
        for (int i = 1; i < n; i++) {
            if (a.get(i) > y) {
                System.out.println("0");
                return;
            } else if (b.get(i) < x) {
                System.out.println("0");
                return;
            } else {
                x = Math.max(x, a.get(i));
                y = Math.min(y, b.get(i));
            }

        }

        System.out.println(y < x ? "0" : y - x + 1);
    }
}
