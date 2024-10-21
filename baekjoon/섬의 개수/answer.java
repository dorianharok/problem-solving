import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int w,h;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0, 1, 1, -1, -1};
    static int[] dy = {0, -1, 0, 1, 1, -1, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;

        while(!(s = br.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(s);
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new int[h][w];

            for(int i=0; i<h; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for(int i=0; i<h; i++) {
                for(int j=0; j<w; j++) {
                    if(map[i][j] == 0) continue;

                    dfs(i, j);
                    count++;
                }
            }

            System.out.println(count);
        }
    }

    public static void dfs(int x, int y) {
        for(int i=0; i<8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
            if(map[nx][ny] == 0) continue;

            map[nx][ny] = 0;
            dfs(nx, ny);
        }
    }
}