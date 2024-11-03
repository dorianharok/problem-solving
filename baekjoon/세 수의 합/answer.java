import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] sum = new int[N * N];
        int idx = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                sum[idx++] = arr[i] + arr[j];
            }
        }
        Arrays.sort(sum);

        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                int target = arr[i] - arr[j];
                int index = binarySearch(sum, target);
                if(index != -1) {
                    max = Math.max(max, arr[i]);
                }
            }
        }

        System.out.println(max);
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}