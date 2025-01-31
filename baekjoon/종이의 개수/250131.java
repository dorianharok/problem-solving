import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int[][] matrix;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, N);

        System.out.println(map.getOrDefault(-1, 0));
        System.out.println(map.getOrDefault(0, 0));
        System.out.println(map.getOrDefault(1, 0));
    }

    public static void partition(int x, int y, int size) {
        if (isSame(x, y, size)) {
            map.merge(matrix[x][y], 1, Integer::sum);
            return;
        }

        size /= 3;

        partition(x, y, size);
        partition(x, y + size, size);
        partition(x, y + size * 2, size);
        partition(x + size, y, size);
        partition(x + size, y + size, size);
        partition(x + size, y + size * 2, size);
        partition(x + size * 2, y, size);
        partition(x + size * 2, y + size, size);
        partition(x + size * 2, y + size * 2, size);
    }

    public static boolean isSame(int x, int y, int size) {
        if(size == 1) {
            return true;
        }

        int p = matrix[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (matrix[i][j] != p) return false;
            }
        }

        return true;
    }
}
