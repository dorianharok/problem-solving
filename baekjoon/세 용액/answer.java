import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        long min = Long.MAX_VALUE;
        long[] answer = new long[3];
        for(int i=0; i<N; i++) {
            for(int j=i+1; j<N-1; j++) {
                long target = -(arr[i] + arr[j]);
                int idx = lowerBound(arr, j + 1, N - 1, target);
                long sum = Math.abs(arr[i] + arr[j] + arr[idx]);
                if(sum < min) {
                    min = sum;
                    answer[0] = arr[i];
                    answer[1] = arr[j];
                    answer[2] = arr[idx];
                }

                if(idx > j + 1) {
                    long temp = Math.abs(arr[i] + arr[j] + arr[idx - 1]);
                    if(temp < min) {
                        min = temp;
                        answer[0] = arr[i];
                        answer[1] = arr[j];
                        answer[2] = arr[idx-1];
                    }
                }
            }
        }

        for(int i=0; i<3; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    public static int lowerBound(long[] arr, int left, int right, long target) {
        while(left < right) {
            int mid = left + (right - left) / 2;

            if(arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
