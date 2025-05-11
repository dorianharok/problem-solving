import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] dp = new int[15][15];
        for(int i=0; i<15; i++) {
            dp[0][i] = i;
        }

        for(int i=1; i<15; i++) {
            for(int j=1; j<15; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[k][n]);
        }
    }
}
