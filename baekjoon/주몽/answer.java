import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        for(int i=0; i<N; i++) {
            int n = Integer.parseInt(st.nextToken());
            map.put(n, 1);
            if(map.containsKey(M - n) && (M - n) != n) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}