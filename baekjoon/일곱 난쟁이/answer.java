import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] arr = new int[9];
    static int[] temp = new int[7];
    static int[] answer = new int[7];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        dfs(0, 0, 0);

        for (int i = 0; i < 7; i++) {
            System.out.println(answer[i]);
        }
    }

    public static void dfs(int start, int depth, int sum) {
        if (depth == 7) {
            if (sum == 100) {
                for (int i = 0; i < 7; i++) {
                    answer[i] = temp[i];
                }
                return;
            }

            return;
        }

        for (int i = start; i < 9; i++) {
            temp[depth] = arr[i];
            dfs(i + 1, depth + 1, sum + arr[i]);
            temp[depth] = 0;
        }
    }
}