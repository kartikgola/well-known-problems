/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package bitcask;

import util.Pair;

import java.io.IOException;
import java.io.RandomAccessFile;

public interface BitcaskReader {

    Pair<String, String> read(RandomAccessFile file, long seekOffset) throws IOException;

}
