import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N];
        int[] record = new int[N];
        int len = 0;
        dp[len++] = arr[0];

        for (int i = 0; i < N; i++) {
            int index = binarySearch(0, len, arr[i]);
            dp[index] = arr[i];
            record[i] = index;
            if(index == len) len++;
        }

        System.out.println(len);
        List<Integer> list = new ArrayList<>();

        len--;
        for(int i=N-1; i>=0; i--) {
            if(record[i] == len) {
                list.add(arr[i]);
                len--;
            }
        }

        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    public static int binarySearch(int start, int end, int key) {
        while(start < end) {
            int mid = (start + end) / 2;

            if(dp[mid] >= key) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}