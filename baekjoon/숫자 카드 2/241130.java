import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

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
            int t = Integer.parseInt(st.nextToken());
            int cnt = upperBound(cards, t) - lowerBound(cards, t);
            sb.append(cnt).append(" ");
        }

        System.out.println(sb);
    }

    public static int lowerBound(int[] arr, int target) {
        int start = 0;
        int end = arr.length;

        while(start < end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    public static int upperBound(int[] arr, int target) {
        int start = 0;
        int end = arr.length;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}
