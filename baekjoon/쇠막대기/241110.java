import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Character> stack = new ArrayDeque<>();

        String s = br.readLine();
        int count = 0;
        char prev = ' ';
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            }

            if (c == ')') {
                stack.pop();
                if (prev == '(') {
                    count += stack.size();
                } else {
                    count++;
                }
            }

            prev = c;
        }

        System.out.println(count);
    }
}