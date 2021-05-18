package ood.bitcask;

import junit.framework.TestCase;

import java.io.IOException;

public class BitcaskAppTest extends TestCase {

    public void test() throws IOException {
        Bitcask bitcask = new BitcaskApp();
        String[][] testCases = new String[][]{
            {"1", "{\"name\": \"Kartik Gola\"}"},
            {"2", "{\"name\": \"John Doe\"}"},
            {"3", "45695372557705094201528985160463597468103075764236"},
            {"4", ""},
            {"2", "{\"name\": \"John Dolo\"}"},
        };

        for (String[] tc: testCases) {
            bitcask.put(tc[0], tc[1]);
        }

        for (String[] tc: testCases) {
            System.out.println(bitcask.get(tc[0]));
        }
    }
}