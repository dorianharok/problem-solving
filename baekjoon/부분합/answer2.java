import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int l = 0, r = 0; l < N; l++) {
            while (r < N && sum < S) {
                sum += arr[r++];
            }

            if (sum >= S) {
                min = Math.min(min, r - l);
            }

            sum -= arr[l];
        }

        if (min == Integer.MAX_VALUE) {
            min = 0;
        }

        System.out.println(min);
    }
}
