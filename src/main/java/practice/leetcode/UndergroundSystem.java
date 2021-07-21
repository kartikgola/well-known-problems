/*
 * Author: Kartik Gola
 * Date: 3/20/21, 1:59 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL:
 */

package practice.leetcode;

import java.util.HashMap;
import java.util.Map;

public class UndergroundSystem {

    static class MovingAverage {
        private int totalTime;
        private int count;

        MovingAverage() {}

        void addTime(int time) {
            totalTime += time;
            count++;
        }

        double getAverageTime() {
            return totalTime / (count * 1.0d);
        }
    }

    static class StationEntry {
        String stationName;
        int entryTime;

        public StationEntry(String stationName, int entryTime) {
            this.stationName = stationName;
            this.entryTime = entryTime;
        }
    }

    private final Map<Integer, StationEntry> checkInHistory = new HashMap<>();
    private final Map<String, Map<String, MovingAverage>> timings = new HashMap<>();

    public UndergroundSystem() {

    }

    public void checkIn(int id, String stationName, int entryTime) {
        checkInHistory.put(id, new StationEntry(stationName, entryTime));
    }

    public void checkOut(int id, String stationName, int exitTime) {
        final String from = checkInHistory.get(id).stationName;
        final String to = stationName;
        final int timeTaken = exitTime - checkInHistory.get(id).entryTime;

        timings.putIfAbsent(from, new HashMap<>());
        timings.get(from).putIfAbsent(to, new MovingAverage());
        timings.get(from).get(to).addTime(timeTaken);
    }

    public double getAverageTime(String startStation, String endStation) {
        return timings.get(startStation).get(endStation).getAverageTime();
    }
}