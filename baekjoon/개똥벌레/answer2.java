import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] down = new int[H + 2];
        int[] up = new int[H + 2];

        for (int i = 0; i < N / 2; i++) {
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());

            down[a]++;
            up[H - b + 1]++;
        }

        for (int i = 1; i <= H; i++) {
            down[i] += down[i - 1];
        }

        for (int i = H-1; i >= 0; i--) {
            up[i] += up[i + 1];
        }

        int min = Integer.MAX_VALUE;
        int count = 0;

        for(int i=1; i<=H; i++) {
            int s = down[H] - down[i-1] + up[0] - up[i+1];
            if(s < min) {
                min = s;
                count = 1;
            } else if (s == min) {
                count++;
            }
        }

        System.out.printf("%d %d", min, count);
    }
}