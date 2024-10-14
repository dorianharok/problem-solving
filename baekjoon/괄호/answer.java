import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            String s = br.readLine();
            if (validate(s)) {
                System.out.println("YES");
                continue;
            }

            System.out.println("NO");
        }

    }

    public static boolean validate(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if(!stack.isEmpty() && stack.peek() == '(' && c == ')') {
                stack.pop();
                continue;
            }

            stack.push(c);
        }

        return stack.isEmpty();
    }
}