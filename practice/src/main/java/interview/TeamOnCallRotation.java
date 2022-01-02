/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package interview;

import java.util.*;
import java.util.stream.Collectors;

public class TeamOnCallRotation {

    private static class Slot {
        int start;
        int end;
        String name;
        Slot(int start, int end, String name) {
            this.start = start;
            this.end = end;
            this.name = name;
        }

        @Override
        public int hashCode() {
            int hash = 0;
            hash = 31 * hash + start;
            hash = 31 * hash + end;
            hash = 31 * hash + (name != null ? name.hashCode() : 0);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Slot))
                return false;
            Slot other = (Slot) obj;
            return start == other.start && end == other.end && name.equals(other.name);
        }
    }

    private static class Roster {
        int start;
        int end;
        List<String> names;
        Roster(int start, int end, List<String> names) {
            this.start = start;
            this.end = end;
            this.names = names;
        }

        @Override
        public String toString() {
            return new StringJoiner(",", "(", ")")
                    .add(String.valueOf(start))
                    .add(String.valueOf(end))
                    .add(names.toString())
                    .toString();
        }
    }

    // Solution using TreeMap (in worst case performs same as a List)
    // O(nlogn + nlogn + n^n) = O(n^2)
    public static List<Roster> getRoster(List<Slot> slots) {
        /*
        *
        * (1,10,A), (5,7,B), (6,12,C), (15,17,D)
        *
        * (1,5), (
        *
        * */
        TreeSet<Integer> times = new TreeSet<>();
        for (Slot slot: slots) {
            times.add(slot.start);
            times.add(slot.end);
        }

        TreeMap<Integer, List<Slot>> ends = new TreeMap<>(Comparator.reverseOrder());
        for (Slot slot: slots) {
            ends.putIfAbsent(slot.end, new ArrayList<>());
            ends.get(slot.end).add(slot);
        }

        TreeMap<Integer, List<Slot>> starts = new TreeMap<>();
        for (Slot slot: slots) {
            starts.putIfAbsent(slot.start, new ArrayList<>());
            starts.get(slot.start).add(slot);
        }

        List<Roster> ans = new ArrayList<>();
        Roster roster = null;
        for (int time: times) {
            if (roster == null) {
                roster = new Roster(time, -1, new ArrayList<>());
            } else {
                roster.end = time;
                // find all slots which have startTime less than roster.end
                Set<Slot> set1 = new HashSet<>();
                for (Map.Entry<Integer, List<Slot>> e: starts.entrySet()) {
                    if (e.getKey() < roster.end) {
                        set1.addAll(e.getValue());
                    } else break;
                }

                // find all slots which have endTime greater than roster.start
                Set<Slot> set2 = new HashSet<>();
                for (Map.Entry<Integer, List<Slot>> e: ends.entrySet()) {
                    if (e.getKey() > roster.start) {
                        set2.addAll(e.getValue());
                    } else break;
                }

                set1.retainAll(set2);
                if (!set1.isEmpty()) {
                    roster.names.addAll(set1.stream().map(slot -> slot.name).collect(Collectors.toList()));
                    ans.add(roster);
                }

                roster = new Roster(time, -1, new ArrayList<>());
            }
        }

        return ans;
    }

    // Solution using PQ which evicts earliest ending slot first
    // O(nlogn + nlogn) = O(nlogn)
    public static List<Roster> getRoster2(List<Slot> slots) {
        Collections.sort(slots, (s1, s2) -> s1.start - s2.start);
        Queue<Slot> pq = new PriorityQueue<>((s1, s2) -> s1.end - s2.end);
        Set<Integer> tempSet = new HashSet<>();
        for (Slot slot: slots) {
            tempSet.add(slot.start);
            tempSet.add(slot.end);
        }

        List<Roster> ans = new ArrayList<>();
        List<Integer> times = new ArrayList<>(tempSet);
        Collections.sort(times);
        Roster roster = new Roster(times.get(0), -1, new ArrayList<>());

        // pointer to List<Slot>
        int j = 0;

        for (int i = 1; i < times.size(); ++i) {
            int time = times.get(i);
            roster.end = time;
            // Add all slots that begin before current roster's end
            while (j < slots.size() && slots.get(j).start < roster.end)
                pq.add(slots.get(j++));

            // Remove all slots that end before current roster's start
            while (!pq.isEmpty() && pq.peek().end <= roster.start)
                pq.poll();

            if (!pq.isEmpty()) {
                roster.names.addAll(pq.stream().map(s -> s.name).collect(Collectors.toList()));
                ans.add(roster);
            }
            roster = new Roster(time, -1, new ArrayList<>());
        }

        return ans;
    }

    public static void main(String[] args) {
        Slot abby = new Slot(1, 10, "abby");
        Slot ben = new Slot(5, 7, "ben");
        Slot carla = new Slot(6, 12, "carla");
        Slot david = new Slot(15, 17, "david");
        System.out.println(getRoster2(Arrays.asList(abby, ben, carla, david)));
    }
}
