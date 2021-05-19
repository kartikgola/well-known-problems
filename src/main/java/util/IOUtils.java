package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class IOUtils {

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static StringTokenizer tokenizer = null;

    /* Integer utilities */
    public static int nextInt() throws IOException {
        if (tokenizer == null)
            tokenizer = new StringTokenizer(reader.readLine());
        int ans = Integer.parseInt(tokenizer.nextToken());
        if (!tokenizer.hasMoreTokens())
            tokenizer = null;
        return ans;
    }

    public static int getInt() throws IOException {
        return getInt(reader);
    }

    public static int getInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    public static int[] getInts(int n) throws IOException {
        return getInts(n, reader);
    }

    public static int[] getInts(int n, BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        return arr;
    }

    public static List<Integer> getIntList(int n) throws IOException {
        return getIntList(n, reader);
    }

    public static List<Integer> getIntList(int n, BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> al = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            al.add(Integer.parseInt(st.nextToken()));
        return al;
    }


    /* Long utilities */
    public static long nextLong() throws IOException {
        if (tokenizer == null)
            tokenizer = new StringTokenizer(reader.readLine());
        long ans = Long.parseLong(tokenizer.nextToken());
        if (!tokenizer.hasMoreTokens())
            tokenizer = null;
        return ans;
    }

    public static long getLong() throws IOException {
        return getLong(reader);
    }

    public static long getLong(BufferedReader br) throws IOException {
        return Long.parseLong(br.readLine());
    }

    public static long[] getLongs(int n) throws IOException {
        return getLongs(n, reader);
    }

    public static long[] getLongs(int n, BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++)
            arr[i] = Long.parseLong(st.nextToken());
        return arr;
    }

    public static List<Long> getLongList(int n) throws IOException {
        return getLongList(n, reader);
    }

    public static List<Long> getLongList(int n, BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Long> al = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            al.add(Long.parseLong(st.nextToken()));
        return al;
    }


    /* Double utilities */
    public static double nextDouble() throws IOException {
        if (tokenizer == null)
            tokenizer = new StringTokenizer(reader.readLine());
        double ans = Double.parseDouble(tokenizer.nextToken());
        if (!tokenizer.hasMoreTokens())
            tokenizer = null;
        return ans;
    }

    public static double getDouble() throws IOException {
        return getLong(reader);
    }

    public static double getDouble(BufferedReader br) throws IOException {
        return Double.parseDouble(br.readLine());
    }

    public static double[] getDoubles(int n) throws IOException {
        return getDoubles(n, reader);
    }

    public static double[] getDoubles(int n, BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        double[] arr = new double[n];
        for (int i = 0; i < n; i++)
            arr[i] = Double.parseDouble(st.nextToken());
        return arr;
    }

    public static List<Double> getDoubleList(int n) throws IOException {
        return getDoubleList(n, reader);
    }

    public static List<Double> getDoubleList(int n, BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Double> al = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            al.add(Double.parseDouble(st.nextToken()));
        return al;
    }


    /* String utilities */
    public static String nextString() throws IOException {
        if (tokenizer == null)
            tokenizer = new StringTokenizer(reader.readLine());
        String ans = tokenizer.nextToken();
        if (!tokenizer.hasMoreTokens())
            tokenizer = null;
        return ans;
    }

    public static String getString() throws IOException {
        return getString(reader);
    }

    public static String getString(BufferedReader br) throws IOException {
        return br.readLine();
    }

    public static String[] getStrings(int n) throws IOException {
        return getStrings(n, reader);
    }

    public static String[] getStrings(int n, BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++)
            arr[i] = st.nextToken();
        return arr;
    }

    public static List<String> getStringList(int n) throws IOException {
        return getStringList(n, reader);
    }

    public static List<String> getStringList(int n, BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<String> al = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            al.add(st.nextToken());
        return al;
    }

}
