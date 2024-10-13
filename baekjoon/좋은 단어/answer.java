import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = 0;
        while(N-- > 0) {
            String s = br.readLine();
            if(isGoodWord(s)) {
                result++;
            }
        }

        System.out.println(result);
    }

    public static boolean isGoodWord(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
                continue;
            }

            stack.push(c);
        }

        return stack.isEmpty();
    }
}