import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        ArrayDeque<Character> temp = new ArrayDeque<>();
        for(int i=0; i<s.length(); i++) {
            stack.push(s.charAt(i));
        }
        int M = Integer.parseInt(br.readLine());

        while(M-- > 0) {
            String command = br.readLine();

            if(command.equals("L")) {
                if(stack.isEmpty()) {
                    continue;
                }
                temp.push(stack.pop());
            } else if (command.equals("D")) {
                if(temp.isEmpty()) {
                    continue;
                }
                stack.push(temp.pop());
            } else if (command.equals("B")) {
                if(stack.isEmpty()) {
                    continue;
                }
                stack.pop();
            } else {
                String[] split = command.split(" ");
                stack.push(split[1].charAt(0));
            }
        }

        while(!temp.isEmpty()) {
            stack.push(temp.pop());
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }

        System.out.println(sb);
    }
}