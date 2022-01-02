/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package codechef.FEB21C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MEET {

    static class Time12 {
        int hr;
        int min;
        boolean isAM;

        Time12() {}

        Time24 toTime24() {
            Time24 t24 = new Time24();
            t24.min = min;
            // 12:00 AM to 11:59 AM => 0000 to 1159
            // 12:00 PM to 11:59 PM => 1200 to 2359
            if (this.isAM) {
                t24.hr = hr % 12;
            } else {
                t24.hr = (hr % 12) + 12;
            }
            return t24;
        }

        static Time12 parse(String t) {
            Time12 t12 = new Time12();
            final String[] arr = t.split(" ");
            t12.isAM = arr[1].equals("AM");
            t12.hr = Integer.parseInt(arr[0].split(":")[0]);
            t12.min = Integer.parseInt(arr[0].split(":")[1]);
            return t12;
        }
    }

    static class Time24 {
        int hr;
        int min;

        Time24() {}

        boolean isBetween(Time24 a, Time24 b) {
            return !((hr < a.hr || (hr == a.hr && min < a.min)) || (b.hr < hr || (hr == b.hr && min > b.min)));
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();

        while (t-- > 0) {
            Time24 p = Time12.parse(br.readLine()).toTime24();
            int n = Integer.parseInt(br.readLine());
            while (n-- > 0) {
                StringTokenizer tokenizer = new StringTokenizer(br.readLine());
                Time24 l = Time12.parse(tokenizer.nextToken() + " " + tokenizer.nextToken()).toTime24();
                Time24 r = Time12.parse(tokenizer.nextToken() + " " + tokenizer.nextToken()).toTime24();
                ans.append(p.isBetween(l, r) ? 1 : 0);
            }
            System.out.println(ans);
            ans.delete(0, ans.length());
        }
    }
}
