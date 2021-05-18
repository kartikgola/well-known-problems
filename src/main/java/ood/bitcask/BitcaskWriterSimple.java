package ood.bitcask;

import java.io.IOException;
import java.io.RandomAccessFile;

public class BitcaskWriterSimple implements BitcaskWriter {

    @Override
    public void write(RandomAccessFile file, String value) throws IOException {
        file.writeBytes(value);
    }
}
