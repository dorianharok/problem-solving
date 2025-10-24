class Solution {
    public int[] solution(int[][] v) {
        int x = 0;
        int y = 0;

        for(int i=0; i<v.length; i++) {
            x ^= v[i][0];
            y ^= v[i][1];
        }

        return new int[]{x, y};
    }
}