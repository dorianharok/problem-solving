import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] dp = new int[2][41];

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for(int i=2; i<=40; i++) {
            dp[0][i] = dp[0][i-1] + dp[0][i-2];
            dp[1][i] = dp[1][i-1] + dp[1][i-2];
        }

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int t = Integer.parseInt(br.readLine());
            System.out.printf("%d %d\n", dp[0][t], dp[1][t]);
        }
    }
}
