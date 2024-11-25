import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[11][11];

        for(int i=1; i<=10; i++) {
            arr[i][0] = 1;
            arr[i][i] = 1;
        }

        for(int i=2; i<=10; i++) {
            for(int j=1; j<=i; j++) {
                arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(arr[a][b]);
    }
}