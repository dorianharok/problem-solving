import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int w, h;
    static char[][] map;
    static ArrayDeque<int[]> fire;
    static ArrayDeque<int[]> human;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            visited = new boolean[h][w];
            fire = new ArrayDeque<>();
            human = new ArrayDeque<>();
            for (int i = 0; i < h; i++) {
                String s = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = s.charAt(j);
                    if (map[i][j] == '*') {
                        fire.add(new int[]{i, j, 0});
                    }
                    if (map[i][j] == '@') {
                        human.add(new int[]{i, j, 0});
                        visited[i][j] = true;
                    }
                }
            }

            System.out.println(bfs());
        }
    }

    public static String bfs() {
        while (!human.isEmpty()) {
            if(!fire.isEmpty()) {
                int fireSize = fire.size();
                for(int f=0; f<fireSize; f++) {
                    int[] cur = fire.poll();

                    for (int i = 0; i < 4; i++) {
                        int nx = cur[0] + dx[i];
                        int ny = cur[1] + dy[i];

                        if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
                            continue;
                        }
                        if (map[nx][ny] == '#' || map[nx][ny] == '*') continue;

                        map[nx][ny] = '*';
                        fire.offer(new int[]{nx, ny, cur[2] + 1});
                    }
                }
            }

            int humanSize = human.size();
            for (int k = 0; k < humanSize; k++) {
                int[] cur = human.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];

                    if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
                        return cur[2] + 1 + "";
                    }
                    if (visited[nx][ny]) continue;
                    if (map[nx][ny] != '.') continue;

                    human.offer(new int[]{nx, ny, cur[2] + 1});
                    visited[nx][ny] = true;
                }
            }

        }

        return "IMPOSSIBLE";
    }

}