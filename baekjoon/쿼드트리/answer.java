import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] image;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        image = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                image[i][j] = s.charAt(j) - '0';
            }
        }

        quadtree(0, 0, N);
        System.out.println(sb);
    }

    public static void quadtree(int x, int y, int size) {
        if (isSame(x, y, size)) {
            sb.append(image[x][y]);

            return;
        }

        int newSize = size / 2;
        sb.append("(");
        quadtree(x, y, newSize);
        quadtree(x, y + newSize, newSize);
        quadtree(x + newSize, y, newSize);
        quadtree(x + newSize, y + newSize, newSize);
        sb.append(")");
    }

    public static boolean isSame(int x, int y, int size) {
        int color = image[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (image[i][j] != color) {
                    return false;
                }
            }
        }

        return true;
    }
}