import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] col;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        col = new int[N];
        Arrays.fill(col, -1);

        System.out.println(solve(0));
    }

    public static int solve(int depth) {
        if (depth == N) {
            return 1;
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            col[depth] = i;
            if (validate(depth)) {
                result += solve(depth + 1);
            }
            col[depth] = -1;
        }

        return result;
    }

    public static boolean validate(int depth) {
        for (int i = 0; i < depth; i++) {
            if (col[depth] == col[i]) return false;
            if ((depth - i) == Math.abs(col[depth] - col[i])) return false;
        }

        return true;
    }
}