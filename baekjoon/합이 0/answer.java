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

        Arrays.sort(arr);

        long count = 0;
        for(int i=0; i<N-2; i++) {
            for(int j=i+1; j<N; j++) {
                int target = -(arr[i] + arr[j]);

                count += upperBound(j+1, N, target) - lowerBound(j+1, N, target);
            }
        }

        System.out.println(count);
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

    public static int upperBound(int left, int right, int target) {
        while(left < right) {
            int mid = (left + right) / 2;

            if(arr[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}