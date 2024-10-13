import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        while (!s.equals(".")) {
            s = s.replaceAll("[^()\\[\\]{}]", "");
            System.out.println(isBalanced(s));
            s = br.readLine();
        }
    }

    public static String isBalanced(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(!stack.isEmpty() && stack.peek() == '(' && c == ')') {
                stack.pop();
            } else if(!stack.isEmpty() && stack.peek() == '[' && c == ']') {
                stack.pop();
            } else if(!stack.isEmpty() && stack.peek() == '{' && c == '}') {
                stack.pop();
            } else if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                return "no";
            }
        }

        if(!stack.isEmpty()) return "no";
        return "yes";
    }
}