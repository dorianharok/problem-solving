import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;
    static int N, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        System.out.println(search());
    }

    public static int search() {
        int left = 0;
        int right = arr[N - 1];
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            boolean possible = isPossible(mid);
            if (possible) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static boolean isPossible(int d) {
        long cnt = 1;
        int prev = -1;

        for (int n : arr) {
            if(prev == -1) {
                prev = n;
                continue;
            }
            if (n - prev >= d) {
                cnt++;
                prev = n;
            }
        }

        return cnt >= C;
    }
}
