import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] down = new int[N/2];
        int[] up = new int[N/2];

        for(int i = 0; i < N/2; i++){
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());

            down[i] = a;
            up[i] = b;
        }

        Arrays.sort(down);
        Arrays.sort(up);

        int min = Integer.MAX_VALUE;
        int count = 0;

        for(int i=1; i<=H; i++) {
            int d = binarySearch(down, i);
            int u = binarySearch(up, H - i + 1);
            int sum = d + u;

            if(sum == min) {
                count++;
            }else if(sum < min) {
                min = sum;
                count = 1;
            }

        }

        System.out.printf("%d %d", min, count);
    }

    public static int binarySearch(int[] arr, int target) {
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

        return arr.length - left;
    }
}