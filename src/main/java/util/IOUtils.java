package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class IOUtils {

    private static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tkn = new StringTokenizer("");

    // Integer
    public static int nextInt() throws Exception {
        while (!tkn.hasMoreTokens())
            tkn = new StringTokenizer(rd.readLine());
        return Integer.parseInt(tkn.nextToken());
    }

    public static int[] nextInts(int n) throws Exception {
        while (!tkn.hasMoreTokens())
            tkn = new StringTokenizer(rd.readLine());
        int[] ans = new int[n];
        for (int i = 0; i < n; i++)
            ans[i] = Integer.parseInt(tkn.nextToken());
        return ans;
    }

    public static List<Integer> nextIntList(int n) throws Exception {
        while (!tkn.hasMoreTokens())
            tkn = new StringTokenizer(rd.readLine());
        List<Integer> ans = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            ans.add(Integer.parseInt(tkn.nextToken()));
        return ans;
    }

    // Long
    public static long nextLong() throws Exception {
        while (!tkn.hasMoreTokens())
            tkn = new StringTokenizer(rd.readLine());
        return Long.parseLong(tkn.nextToken());
    }

    public static long[] nextLongs(int n) throws Exception {
        while (!tkn.hasMoreTokens())
            tkn = new StringTokenizer(rd.readLine());
        long[] ans = new long[n];
        for (int i = 0; i < n; i++)
            ans[i] = Long.parseLong(tkn.nextToken());
        return ans;
    }

    public static List<Long> nextLongList(int n) throws Exception {
        while (!tkn.hasMoreTokens())
            tkn = new StringTokenizer(rd.readLine());
        List<Long> ans = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            ans.add(Long.parseLong(tkn.nextToken()));
        return ans;
    }

    // Double
    public static double nextDouble() throws Exception {
        while (!tkn.hasMoreTokens())
            tkn = new StringTokenizer(rd.readLine());
        return Double.parseDouble(tkn.nextToken());
    }

    public static double[] nextDouble(int n) throws Exception {
        while (!tkn.hasMoreTokens())
            tkn = new StringTokenizer(rd.readLine());
        double[] ans = new double[n];
        for (int i = 0; i < n; i++)
            ans[i] = Double.parseDouble(tkn.nextToken());
        return ans;
    }

    public static List<Double> nextDoubleList(int n) throws Exception {
        while (!tkn.hasMoreTokens())
            tkn = new StringTokenizer(rd.readLine());
        List<Double> ans = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            ans.add(Double.parseDouble(tkn.nextToken()));
        return ans;
    }

    // String
    public static String nextString() throws Exception {
        while (!tkn.hasMoreTokens())
            tkn = new StringTokenizer(rd.readLine());
        return tkn.nextToken();
    }

    public static String[] nextStrings(int n) throws Exception {
        while (!tkn.hasMoreTokens())
            tkn = new StringTokenizer(rd.readLine());
        String[] ans = new String[n];
        for (int i = 0; i < n; i++)
            ans[i] = tkn.nextToken();
        return ans;
    }

    public static List<String> nextStringList(int n) throws Exception {
        while (!tkn.hasMoreTokens())
            tkn = new StringTokenizer(rd.readLine());
        List<String> ans = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            ans.add(tkn.nextToken());
        return ans;
    }

}
