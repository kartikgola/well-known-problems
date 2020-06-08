package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MMass {

    private int getMolMass(String input) {
        int mmass = 0; char ch;
        for ( int i = 0; i < input.length(); ++i ) {
            ch = input.charAt(i);
            if ( ch == 'C' ) {
                mmass += 12;
            } else if ( ch == 'O' ) {
                mmass += 16;
            } else {
                mmass += 1;
            }
        }
        return mmass;
    }

    private String repeatString(String str, int times) {
        StringBuilder builder = new StringBuilder(str);
        for ( int i = 0; i < times - 1; ++i ) {
            builder.append(str);
        }
        return builder.toString();
    }

    public void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Stack<String> stack = new Stack<>();
        final String CHO = "CHO";
        final String OPENING_PARENTHESIS = "(";
        final String CLOSING_PARENTHESIS = ")";
        StringBuilder builder = new StringBuilder();

        for ( int i = 0; i < input.length(); ++i) {
            final String ch = Character.toString(input.charAt(i));
            if ( ch.equals(OPENING_PARENTHESIS) ) {
                stack.push(ch);
            } else if ( ch.equals(CLOSING_PARENTHESIS) ) {
                while ( !stack.peek().equals(OPENING_PARENTHESIS) ) {
                    builder.insert(0, stack.pop());
                }
                stack.pop();
                stack.push(builder.toString());
                builder.setLength(0);
            } else if ( CHO.contains(ch) ) {
                stack.push(ch);
            } else {
                int repeat = Integer.parseInt(ch);
                builder.append(stack.pop());
                stack.push( this.repeatString(builder.toString(), repeat) );
                builder.setLength(0);
            }
        }

        long molMass = 0L;
        while ( !stack.empty() ) {
            molMass += this.getMolMass( stack.pop() );
        }

        System.out.println(molMass);
    }
}
