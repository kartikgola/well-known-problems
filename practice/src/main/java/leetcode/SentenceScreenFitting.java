/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class SentenceScreenFitting {

    public int wordsTyping(String[] sentence, int rows, int cols) {
        // Join the sentence[] with spaces and an end space
        // We can place a pointer "begin" in this new sentence, "S" & keep moving it by "cols"
        // if "begin" ends up on a space (" "), move 1 step ahead
        // else if, "begin" ends up inside a word, example,
        //  0123456789
        // "abc def gh" & begin = 5, move back begin until it points to starting char
        // of the word ("d" in this case, final begin = 4)
        // Answer = value of begin pointer / length(S)
        String s = String.join(" ", sentence) + " ";
        final int n = s.length();
        int begin = 0;
        for (int r = 0; r < rows; ++r) {
            begin += cols;
            if (s.charAt(begin % n) == ' ') {
                begin++;
            } else {
                while (begin > 0 && s.charAt((begin-1) % n) != ' ') {
                    begin--;
                }
            }
        }
        return begin / n;
    }
}
