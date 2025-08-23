import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<>();

        int[] answer = new int[prices.length];

        for(int i=0; i<prices.length; i++) {
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int prev = stack.pop();
                answer[prev] = i - prev;
            }

            stack.push(i);
        }

        while(!stack.isEmpty()) {
            int prev = stack.pop();
            answer[prev] = prices.length - prev -1;
        }

        return answer;
    }
}