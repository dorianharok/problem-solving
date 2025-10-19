import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] shellAtPos = new int[3];
        for (int i = 0; i < 3; i++) {
            shellAtPos[i] = i;
        }

        int[] counter = new int[3];

        for (int i = 0; i < n; i++) {
            String[] c = br.readLine().split(" ");
            int a = Integer.parseInt(c[0]) - 1;
            int b = Integer.parseInt(c[1]) - 1;
            int g = Integer.parseInt(c[2]) - 1;

            int temp = shellAtPos[a];
            shellAtPos[a] = shellAtPos[b];
            shellAtPos[b] = temp;

            counter[shellAtPos[g]]++;
        }

        System.out.println(Math.max(counter[0], Math.max(counter[1], counter[2])));
    }
}