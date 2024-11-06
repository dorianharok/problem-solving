import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for(int i=N-1; i>=0; i--) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int coin = 0;
        int idx = 0;
        while(K > 0 && idx < N) {
            coin += K / arr[idx];
            K %= arr[idx++];
        }

        System.out.println(coin);
    }
}