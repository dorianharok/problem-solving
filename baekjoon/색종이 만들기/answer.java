import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int white;
    static int blue;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void partition(int x, int y, int size) {
        if(isSameColor(x, y, size)) {
            if(map[x][y] == 0) {
                white++;
            } else {
                blue++;
            }

            return;
        }

        int newSize = size / 2;

        partition(x, y, newSize);
        partition(x, y+newSize, newSize);
        partition(x + newSize, y, newSize);
        partition(x + newSize, y + newSize, newSize);
    }

    public static boolean isSameColor(int x, int y, int size) {
        int color = map[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if(map[i][j] != color) {
                    return false;
                }
            }
        }

        return true;
    }
}