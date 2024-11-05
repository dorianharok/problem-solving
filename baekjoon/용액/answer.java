import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        int[] ans = new int[2];

        for (int i = 0; i < N-1; i++) {
            int target = -arr[i];
            int idx = lowerBound(i+1, N-1, target);
            int sum = Math.abs(arr[i] + arr[idx]);

            if(sum < min) {
                min = sum;
                ans[0] = Math.min(arr[i], arr[idx]);
                ans[1] = Math.max(arr[i], arr[idx]);
            }

            if(idx > i+1) {
                sum = Math.abs(arr[i] + arr[idx-1]);
                if(sum < min) {
                    min = sum;
                    ans[0] = Math.min(arr[i], arr[idx-1]);
                    ans[1] = Math.max(arr[i], arr[idx-1]);
                }
            }
        }

        System.out.printf("%d %d", ans[0], ans[1]);
    }

    public static int lowerBound(int left, int right, int target) {
        while(left < right) {
            int mid = (left + right) / 2;

            if(arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}