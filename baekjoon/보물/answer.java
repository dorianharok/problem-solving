import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> A = new PriorityQueue<>();
        PriorityQueue<Integer> B = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B.add(Integer.parseInt(st.nextToken()));
        }

        int min = 0;
        for(int i = 0; i < N; i++) {
            min += A.poll() * B.poll();
        }

        System.out.println(min);
    }
}