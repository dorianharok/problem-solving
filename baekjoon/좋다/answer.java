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
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 이진 탐색을 위한 정렬
        Arrays.sort(arr);

        int count = 0;
        for(int i = 0; i < N; i++) {
            int target = arr[i];

            int left = 0;
            int right = N - 1;
            while(left < right) {
                int sum = arr[left] + arr[right];

                if(sum == target) {
                    if(left != i && right != i) {
                        count++;
                        break;
                    } else if (left == i) {
                        left++;
                    } else {
                        right--;
                    }
                } else if(sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        System.out.println(count);
    }
}