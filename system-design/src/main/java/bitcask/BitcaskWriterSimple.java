/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package bitcask;

import java.io.IOException;
import java.io.RandomAccessFile;

public class BitcaskWriterSimple implements BitcaskWriter {

    @Override
    public void write(RandomAccessFile file, String value) throws IOException {
        file.writeBytes(value);
    }
}
