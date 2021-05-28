package ood.bitcask;

import util.Pair;

import java.io.IOException;
import java.io.RandomAccessFile;

public class BitcaskReaderSimple implements BitcaskReader {

    @Override
    public Pair<String, String> read(RandomAccessFile file, long seekOffset) throws IOException {
        file.seek(seekOffset);
        byte[] buffer = new byte[32];
        file.read(buffer, 0, buffer.length);
        final int contentLen = Integer.parseInt(new String(buffer), 2);

        file.seek(seekOffset + 33);
        buffer = new byte[contentLen];
        file.read(buffer, 0, buffer.length);

        final String val = new String(buffer);
        return new Pair<>(val.substring(0, val.indexOf(':') - 1), val.substring(val.indexOf(':') + 1));
    }
}
