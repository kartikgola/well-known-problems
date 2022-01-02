/*
 * Author: Kartik Gola
 * Date: 12/6/21, 10:58 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://leetcode.com/discuss/interview-question/1612893/Booking.com-or-onsite-or-please-can-someone-post-this-question-exactly-and-java-dfs-solution/1172236
 */

package practice.interview;

import java.util.*;

public class LongestItinerary {

    static class Ticket {
        String from;
        String to;
        int date;
        int price;
        Ticket(String from, String to, int date, int price) {
            this.from = from;
            this.to = to;
            this.date = date;
            this.price = price;
        }
    }

    static class Itinerary {
        List<String> order;
        int cost;
        Itinerary(List<String> order, int cost) {
            this.order = order;
            this.cost = cost;
        }
        @Override
        public String toString() {
            return "Itinerary{" +
                    "order=" + order +
                    ", cost=" + cost +
                    '}';
        }
    }

    private static Itinerary best = new Itinerary(new ArrayList<>(), Integer.MAX_VALUE);
    private static Map<String, List<Ticket>> fromMap = new HashMap<>();
    private static Map<String, Integer> priceMap;

    private static void dfs(String from, int prevDate, int cost, int budget, Set<Ticket> used, List<String> order) {
        if (cost > budget)
            return;
        order.add(from);
        if (order.size() > 1 && order.get(0).equals(order.get(order.size()-1))) {
            if (order.size() > best.order.size() || (order.size() == best.order.size() && cost < best.cost))
                best = new Itinerary(order, cost);
        }
        for (Ticket ticket: fromMap.getOrDefault(from, new ArrayList<>())) {
            if (!used.contains(ticket) && ticket.date > prevDate) {
                used.add(ticket);
                int hotelCost = 0;
                if (prevDate > 0)
                    hotelCost = (ticket.date - prevDate) * priceMap.get(from);
                dfs(ticket.to, ticket.date, cost + ticket.price + hotelCost, budget, used, new ArrayList<>(order));
                used.remove(ticket);
            }
        }
    }

    public static void main(String[] args) {
        Ticket t1 = new Ticket("Amsterdam", "Paris", 10, 300);
        Ticket t2 = new Ticket("London", "Paris", 15, 410);
        Ticket t3 = new Ticket("Paris", "London", 13, 300);
        Ticket t4 = new Ticket("London", "Amsterdam", 17, 400);
        Ticket t5 = new Ticket("Paris", "Amsterdam", 21, 500);

        priceMap = Map.of(
                "Amsterdam", 400,
                "Paris", 500,
                "London", 300
        );
        fromMap = Map.of(
                "Amsterdam", Arrays.asList(t1),
                "Paris", Arrays.asList(t3, t5),
                "London", Arrays.asList(t2, t4)
        );

        dfs("Amsterdam", -1, 0, 4000, new HashSet<>(), new ArrayList<>());
        System.out.println(best);
    }
}
