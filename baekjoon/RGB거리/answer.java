import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] rgb = new int[N+1][N+1];

        for(int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                rgb[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<=N; i++) {
            rgb[i][0] = Math.min(rgb[i-1][1], rgb[i-1][2]) + rgb[i][0];
            rgb[i][1] = Math.min(rgb[i-1][0], rgb[i-1][2]) + rgb[i][1];
            rgb[i][2] = Math.min(rgb[i-1][0], rgb[i-1][1]) + rgb[i][2];
        }

        int result = Integer.MAX_VALUE;
        for(int i=0; i<3; i++) {
            result = Math.min(result, rgb[N][i]);
        }

        System.out.println(result);
    }
}