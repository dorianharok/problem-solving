import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(M-- > 0) {
            int target = Integer.parseInt(st.nextToken());
            int count = upperBound(cards, target) - lowerBound(cards, target);
            sb.append(count).append(" ");
        }

        System.out.println(sb);
    }

    public static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

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

    public static int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

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