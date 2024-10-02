import java.util.*;

// prefix sum
class Solution {
    public int solution(int[] mats, String[][] park) {
        int[][] sum = new int[park.length+1][park[0].length+1];

        for (int i = 1; i <= park.length; i++) {
            for(int j = 1; j <= park[0].length; j++) {
                int origin = park[i-1][j-1].equals("-1") ? 1 : 0;
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + origin;
            }
        }

        int rows = park.length;
        int cols = park[0].length;

        int max = -1;
        Arrays.sort(mats);
        for(int k = mats.length - 1; k >=0 ; k--){
            int size = mats[k];
            boolean found = false;
            for (int i = size; i <= rows; i++) {
                for(int j = size; j <= cols; j++) {
                    int x = i - size + 1;
                    int y = j - size + 1;

                    if(!valid(x, y, size, rows +1, cols +1)) {
                        continue;
                    }

                    int result = sum[i][j] - sum[x-1][j] - sum[i][y-1] + sum[x-1][y-1];
                    if(result == size * size) {
                        max = size;
                        found = true;
                        break;
                    }
                }
                if(found){
                    break;
                }
            }
            if(found){
                break;
            }
        }

        return max;
    }

    public boolean valid(int x, int y, int s, int maxX, int maxY) {
        if(x < 1 || y < 1 || x + s - 1 > maxX - 1 || y + s - 1 > maxY - 1) {
            return false;
        }
        return true;
    }
}