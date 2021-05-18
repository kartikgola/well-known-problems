package ood.bitcask;

import java.io.IOException;
import java.io.RandomAccessFile;

public interface BitcaskWriter {

    void write(RandomAccessFile file, String value) throws IOException;
}
