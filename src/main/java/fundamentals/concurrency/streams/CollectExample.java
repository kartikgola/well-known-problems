package fundamentals.concurrency.streams;

import java.util.Arrays;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectExample {

    private static void collectExample() {
        Stream<String> stream = Stream.of("w", "o", "l", "f").parallel();
        // Collecting in a SortedSet
        SortedSet<String> set = stream.collect(ConcurrentSkipListSet::new,
                Set::add,
                Set::addAll);
        System.out.println(set); // [f, l, o, w]
    }

    private static void collectExample2() {
        Stream<String> stream = Stream.of("w", "o", "l", "f").parallel();
        // Collecting in HashSet
        Set<String> set = stream.collect(Collectors.toSet());
        System.out.println(set); // [f, w, l, o]
    }

    public static void main(String[] args) {
        collectExample();
        collectExample2();
    }
}
