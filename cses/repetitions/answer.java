import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();

        int max = Integer.MIN_VALUE;
        int cnt = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(!stack.isEmpty() && stack.peek() == c) {
                cnt++;
            } else {
                stack.push(c);
                cnt = 1;
            }

            max = Math.max(max, cnt);
        }

        System.out.println(max);
    }
}
