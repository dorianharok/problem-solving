import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int current = 1;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        while(N-- > 0) {
            int target = Integer.parseInt(br.readLine());

            while(current <= target) {
                stack.push(current++);
                sb.append("+").append("\n");
            }

            if(stack.peek() > target) {
                System.out.println("NO");
                return;
            }

            if(stack.peek() == target) {
                stack.pop();
                sb.append("-").append("\n");
            }
        }

        System.out.println(sb);
    }
}