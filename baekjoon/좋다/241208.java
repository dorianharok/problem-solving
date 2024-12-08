import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (isGood(arr, i)) cnt++;
        }

        System.out.println(cnt);
    }

    public static boolean isGood(int[] arr, int targetIndex) {
        int l = 0;
        int r = arr.length - 1;
        int target = arr[targetIndex];

        while (l < r) {
            if (l == targetIndex) l++;
            else if (r == targetIndex) r--;
            else {
                if (arr[r] + arr[l] == target) return true;
                else if (arr[r] + arr[l] > target) r--;
                else l++;
            }

        }

        return false;
    }
}
