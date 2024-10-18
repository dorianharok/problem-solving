import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int[][] paper;
    static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        paper = new int[N][N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, N);

        System.out.println(map.getOrDefault(-1, 0));
        System.out.println(map.getOrDefault(0, 0));
        System.out.println(map.getOrDefault(1, 0));
    }

    public static void partition(int x, int y, int size) {
        if(isSame(x, y, size)) {
            map.put(paper[x][y], map.getOrDefault(paper[x][y], 0) + 1);
            return;
        }

        int term = size / 3;

        partition(x, y, term);
        partition(x, y + term, term);
        partition(x, y + term * 2, term);
        partition(x + term, y, term);
        partition(x + term, y + term, term);
        partition(x + term, y + term * 2, term);
        partition(x + term * 2, y, term);
        partition(x + term * 2, y + term, term);
        partition(x + term * 2, y + term * 2, term);
    }

    public static boolean isSame(int x, int y, int size) {
        int p = paper[x][y];

        for(int i=x; i<x + size; i++) {
            for(int j=y; j<y + size; j++) {
                if(paper[i][j] != p) {
                    return false;
                }
            }
        }

        return true;
    }
}