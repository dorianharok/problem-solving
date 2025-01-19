import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;

        for(int i=3; i<=100; i++) {
            dp[i] = dp[i-3] + dp[i-2];
        }

        int N = Integer.parseInt(br.readLine());
        while(N-- > 0) {
            System.out.println(dp[Integer.parseInt(br.readLine())]);
        }
    }
}
