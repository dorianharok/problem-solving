import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[][] command = new String[n][3];
        for (int i = 0; i < n; i++) {
            command[i] = br.readLine().split(" ");
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            boolean[] pebble = new boolean[n + 1];
            pebble[i] = true;
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                int a = Integer.parseInt(command[j][0]);
                int b = Integer.parseInt(command[j][1]);
                int g = Integer.parseInt(command[j][2]);

                swap(a, b, pebble);
                if(pebble[g]) {
                    cnt++;
                }
            }
            max = Math.max(max, cnt);
        }

        System.out.println(max);
    }

    public static void swap(int a, int b, boolean[] pebble) {
        if (pebble[a] || pebble[b]) {
            pebble[a] = !pebble[a];
            pebble[b] = !pebble[b];
        }
    }
}