/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package codechef.FEB21C;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HDIVISR {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int div = 10; div >= 1; --div) {
           if (n % div == 0) {
               System.out.println(div);
               break;
           }
        }
    }
}
