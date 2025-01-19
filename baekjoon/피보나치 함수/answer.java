import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[][] arr = new int[41][2];
        arr[0][0] = 1;
        arr[1][1] = 1;

        for(int i=2; i<=40; i++) {
            arr[i][0] = arr[i-1][0] + arr[i-2][0];
            arr[i][1] = arr[i-1][1] + arr[i-2][1];
        }

        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(arr[n][0]).append(" ").append(arr[n][1]).append("\n");
        }

        System.out.println(sb);
    }
}
