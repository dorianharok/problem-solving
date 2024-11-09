import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int white;
    static int blue;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        portion(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    public static boolean isSame(int x, int y, int length, int target) {
        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if (paper[i][j] != target) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void portion(int x, int y, int length) {
        if(isSame(x, y, length, paper[x][y])) {
            if(paper[x][y] == 0) {
                white++;
            }else {
                blue++;
            }

            return;
        }

        int next = length / 2;

        portion(x, y, next);
        portion(x + next, y, next);
        portion(x, y + next, next);
        portion(x + next, y + next, next);
    }
}