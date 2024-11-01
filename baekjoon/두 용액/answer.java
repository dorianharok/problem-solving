import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;
        int abs = Integer.MAX_VALUE;
        int[] answer = new int[2];

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (Math.abs(sum) < abs) {
                abs = Math.abs(sum);
                answer[0] = arr[left];
                answer[1] = arr[right];
            }

            if (sum > 0) {
                right--;
            } else if (sum == 0) {
                break;
            } else {
                left++;
            }
        }

        System.out.printf("%d %d", answer[0], answer[1]);
    }
}