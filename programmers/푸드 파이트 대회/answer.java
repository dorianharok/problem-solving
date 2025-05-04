class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<food.length; i++) {
            int n = food[i] / 2;
            while(n-- > 0) {
                sb.append(i);
            }
        }

        return sb.toString() + "0" + sb.reverse();
    }
}