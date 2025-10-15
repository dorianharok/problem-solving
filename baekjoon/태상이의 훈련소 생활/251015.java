import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] heights = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        int[] command = new int[N + 2];
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            command[start] += height;
            command[end + 1] -= height;
        }

        int prev = 0;
        for(int i=1; i<=N; i++) {
            command[i] += prev;
            prev = command[i];
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) {
            heights[i] += command[i];
            sb.append(heights[i]).append(" ");
        }

        System.out.println(sb);
    }
}