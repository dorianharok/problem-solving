import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        int[][] arr = new int[N][N];
        for(int i=0; i<N; i++) {
            s = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        int[][] sum = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                sum[i][j] = sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1] + arr[i-1][j-1];
            }
        }

        StringBuilder sb = new StringBuilder();
        while(M-- > 0) {
            s = br.readLine().split(" ");
            int x1 = Integer.parseInt(s[0]);
            int y1 = Integer.parseInt(s[1]);
            int x2 = Integer.parseInt(s[2]);
            int y2 = Integer.parseInt(s[3]);

            int result = sum[x2][y2] - sum[x2][y1-1] - sum[x1-1][y2] + sum[x1-1][y1-1];
            sb.append(result + "\n");
        }

        System.out.println(sb);
    }
}