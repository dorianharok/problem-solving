class Solution {
    public int solution(int n) {
        int base = Integer.bitCount(n);

        for(int i=n+1; i<=Integer.MAX_VALUE; i++) {
            if(base == Integer.bitCount(i)) {
                return i;
            }
        }

        return 0;
    }
}