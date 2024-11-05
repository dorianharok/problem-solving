import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Set<Integer> set  = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            arr[i] = n;
            set.add(n);
        }

        int[] points = new int[set.size()];
        AtomicInteger idx = new AtomicInteger(0);
        set.stream().forEach(i -> points[idx.getAndIncrement()] = i);
        Arrays.sort(points);

        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(lowerBound(points, i)).append(" ");
        }

        System.out.println(sb);
    }

    public static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}