import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        int x = 0;
        int y = 0;
        int dir = 0;
        int[] targetIdx = new int[2];
        for(int i=N * N; i > 0; i--) {
            arr[x][y] = i;
            if(arr[x][y] == target) {
                targetIdx[0] = x + 1;
                targetIdx[1] = y + 1;
            }

            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(nx < 0 || nx >= N || ny < 0 || ny >= N || arr[nx][ny] != 0) {
                dir = (dir + 1) % 4;
            }

            x = x + dx[dir];
            y = y + dy[dir];
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(targetIdx[0]).append(" ").append(targetIdx[1]);

        System.out.println(sb);
    }
}