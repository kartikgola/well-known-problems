package ood.bitcask;

import java.io.IOException;

public interface Bitcask {

    void put(String key, String value) throws IOException;

    String get(String key) throws IOException;
}
