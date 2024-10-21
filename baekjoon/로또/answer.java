import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static int[] arr;
    static boolean[] visited;
    static int[] lotto;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;

        while (!(s = br.readLine()).equals("0")) {
            StringTokenizer st = new StringTokenizer(s);

            k = Integer.parseInt(st.nextToken());
            lotto = new int[k];
            arr = new int[k];
            visited = new boolean[k];
            sb = new StringBuilder();
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            bt(0, 0);
            System.out.println(sb);
        }
    }

    public static void bt(int start, int index) {
        if (index == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(lotto[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < k; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            lotto[index] = arr[i];
            bt(i+1, index+1);
            lotto[index] = 0;
            visited[i] = false;
        }
    }
}