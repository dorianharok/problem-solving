import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            System.out.println(keyLogger(br.readLine()));
        }
    }

    public static String keyLogger(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        ArrayDeque<Character> temp = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c == '<') {
                if(stack.isEmpty()) {
                    continue;
                }

                temp.push(stack.pop());
            }
            else if(c == '>') {
                if(temp.isEmpty()) {
                    continue;
                }

                stack.push(temp.pop());
            } else if (c == '-') {
                if(stack.isEmpty()) {
                    continue;
                }

                stack.pop();
            } else {
                stack.push(c);
            }
        }

        while(!temp.isEmpty()) {
            stack.push(temp.pop());
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}