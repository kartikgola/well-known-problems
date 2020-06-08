package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ArrayInput {

    public static int[] readArray(BufferedReader reader, int n) throws IOException {
        return ArrayInput.readArray(reader, n, " ");
    }

    private static int[] readArray(BufferedReader reader, int n, String delim) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), delim);
        int[] arr = new int[n];
        int i = 0;
        while ( tokenizer.hasMoreTokens() ) {
            arr[i++] = Integer.parseInt(tokenizer.nextToken());
        }
        return arr;
    }

    public static ArrayList<Integer> readArrayList(BufferedReader reader) throws IOException {
        return ArrayInput.readArrayList(reader, " ");
    }

    private static ArrayList<Integer> readArrayList(BufferedReader reader, String delim) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), delim);
        ArrayList<Integer> arrayList = new ArrayList<>();
        while ( tokenizer.hasMoreTokens() ) {
            arrayList.add(Integer.parseInt(tokenizer.nextToken()));
        }
        return arrayList;
    }
}
