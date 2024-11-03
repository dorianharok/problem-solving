import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N];
        dp[0] = A[0];
        int len = 1;

        for(int i=1; i<N; i++) {
            int index = binarySearch(0, len, A[i]);
            dp[index] = A[i];
            if(index == len) len++;
        }

        System.out.println(len);
    }

    public static int binarySearch(int left, int right, int key) {
        while(left < right) {
            int mid = (left + right) / 2;

            if(dp[mid] >= key) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}