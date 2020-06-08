package geeksforgeeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FourPointsSquare {

    private class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private int getLengthSq(Point p, Point q) {
        return (p.x - q.x) * (p.x - q.x) + (p.y - q.y) * (p.y - q.y);
    }

    public void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        while ( t-- > 0 ) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            Point p = new Point(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
            tokenizer = new StringTokenizer(reader.readLine(), " ");
            Point q = new Point(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
            tokenizer = new StringTokenizer(reader.readLine(), " ");
            Point r = new Point(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
            tokenizer = new StringTokenizer(reader.readLine(), " ");
            Point s = new Point(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));

            // Check three different lengths
            int len1 = getLengthSq(p, q);
            int len2 = getLengthSq(p, r);
            int len3 = getLengthSq(p, s);

            // Two of the above lengths must be same and the third should be 2 times the other
            if ( len1 == len2 && 2 * len1 == len3 ) {
                System.out.println("Square");
            } else if ( len1 == len3 && 2 * len1 == len2 ) {
                System.out.println("Square");
            } else if ( len2 == len3 && 2 * len2 == len1 ) {
                System.out.println("Square");
            } else {
                System.out.println("Not Square");
            }
        }
    }

}
