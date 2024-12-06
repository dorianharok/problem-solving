import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, sum;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            arr[i] = n;
            sum += n;
        }

        System.out.println(binarySearch());
    }

    public static int binarySearch() {
        int left = Arrays.stream(arr).max().getAsInt();
        int right = sum;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPossible(mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static boolean isPossible(int size) {
        int count = 1;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i] > size) return false;

            if (sum + arr[i] > size) {
                count++;
                sum = arr[i];
            } else {
                sum += arr[i];
            }
        }

        return count <= M;
    }
}
