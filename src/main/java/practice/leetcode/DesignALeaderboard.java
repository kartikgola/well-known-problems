/*
 * Author: Kartik Gola
 * Date: 12/10/21, 10:05 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class DesignALeaderboard {

    // Sorted map that will store {score=count_of_players_with_this_score}
    private TreeMap<Integer, Integer> scoreCount = new TreeMap<>(Comparator.reverseOrder());
    // Hash map that will store {playerId=score}
    private Map<Integer, Integer> playerScore = new HashMap<>();

    public DesignALeaderboard() {

    }

    private void decreaseCount(int score) {
        scoreCount.put(score, scoreCount.get(score)-1);
        if (scoreCount.get(score) == 0)
            scoreCount.remove(score);
    }

    public void addScore(int playerId, int score) {
        if (playerScore.containsKey(playerId)) {
            int sc = playerScore.get(playerId);
            decreaseCount(sc);
            scoreCount.put(sc+score, scoreCount.getOrDefault(sc+score, 0)+1);
            playerScore.put(playerId, sc+score);
        } else {
            playerScore.put(playerId, score);
            scoreCount.put(score, scoreCount.getOrDefault(score, 0)+1);
        }
    }

    public int top(int K) {
        int ans = 0;
        for (Map.Entry<Integer, Integer> e: scoreCount.entrySet()) {
            if (K <= 0)
                break;
            int take = Math.min(K, e.getValue());
            ans += e.getKey() * take;
            K -= take;
        }
        return ans;
    }

    public void reset(int playerId) {
        int sc = playerScore.get(playerId);
        decreaseCount(sc);
        playerScore.remove(playerId);
    }
}
