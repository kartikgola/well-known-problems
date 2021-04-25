package fundamentals.concurrency.streams;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StreamReduceExample {

    private static void reduceExample() {
        System.out.println(
            Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g')
                .parallelStream()
                // .reduce() on parallel stream makes sure that order is preserved
                .reduce("",
                        (ch, str1) -> ch + str1,
                        (str2, str3) -> str2 + str3)
        );
    }

    public static void main(String[] args) {
        reduceExample();
    }
}
