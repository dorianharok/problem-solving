import java.util.*;

// dp
class Solution {
    public int solution(int[] mats, String[][] park) {
        int[][] dp = new int[park.length+1][park[0].length+1];

        int max = 0;
        for (int i = 1; i <= park.length; i++) {
            for(int j = 1; j <= park[0].length; j++) {
                if (!park[i-1][j-1].equals("-1")) {
                    continue;
                }

                dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
                max = Math.max(max, dp[i][j]);
            }
        }

        Arrays.sort(mats);
        for(int i = mats.length-1; i>=0; i--) {
            if(mats[i] <= max) {
                return mats[i];
            }
        }

        return -1;
    }
}