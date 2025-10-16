import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] arr = new int[W];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0;
        int r = W - 1;
        int leftMax = arr[l], rightMax = arr[r];

        int answer = 0;
        while(l < r) {
            if(leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, arr[l]);
                answer += leftMax - arr[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, arr[r]);
                answer += rightMax - arr[r];
            }
        }

        System.out.println(answer);
    }
}