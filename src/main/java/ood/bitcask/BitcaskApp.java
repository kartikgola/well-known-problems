/*
 * Author: Kartik Gola
 * Date: 5/18/21, 3:00 PM
 * Copyright (c) 2021 | https://rattl.io
 */

package ood.bitcask;

import javafx.util.Pair;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;

public class BitcaskApp implements Bitcask {

    private BitcaskReader reader = new BitcaskReaderSimple();
    private BitcaskWriter writer = new BitcaskWriterSimple();
    private RandomAccessFile file = new RandomAccessFile("src/main/java/ood/bitcask/data.txt", "rw");
    private final String SEPARATOR = ":";
    private final Map<String, Long> seekOffsetMap = new HashMap<>();
    private long writeSeekPos = 0;

    public BitcaskApp() throws FileNotFoundException {
    }

    @Override
    public void put(String key, String value) throws IOException {
        seekOffsetMap.put(key, writeSeekPos);
        StringBuilder sb = new StringBuilder()
            .append(Long.toBinaryString(Integer.toUnsignedLong(key.length() + value.length() + SEPARATOR.length()) | 0x100000000L).substring(1))
            .append("\n")
            .append(key)
            .append(":")
            .append(value)
            .append("\n");
        writer.write(file, sb.toString());
        writeSeekPos = file.getFilePointer();
    }

    @Override
    public String get(String key) throws IOException {
        if (seekOffsetMap.containsKey(key)) {
            Pair<String, String> pair = reader.read(file, seekOffsetMap.get(key));
            return pair.getValue();
        }
        return null;
    }
}
