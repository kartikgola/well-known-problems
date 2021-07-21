package practice.atcoder.abc200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class TaskC {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long ans = 0;
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int mod = arr[i] % 200;
            ans += map.getOrDefault(mod, 0l);
            map.put(mod, map.getOrDefault(mod, 0l) + 1);
        }

        System.out.println(ans);
    }
}
