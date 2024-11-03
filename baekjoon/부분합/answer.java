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

        int[] sum = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            sum[i] = Integer.parseInt(st.nextToken()) + sum[i - 1];
        }

        int left = 0;
        int right = 1;
        int len = Integer.MAX_VALUE;

        while(right <= N && left < right) {
            int result = sum[right] - sum[left];

            if(result >= S) {
                len = Math.min(len, right - left);
                left++;
            } else {
                right++;
            }
        }

        if(len == Integer.MAX_VALUE) {
            len = 0;
        }
        System.out.println(len);
    }
}