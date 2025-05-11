import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Point[] points = new Point[N];
        StringTokenizer st;
        for(int i=0 ; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            points[i] = new Point(x, y);
        }

        Arrays.sort(points, (o1, o2) -> {
            if(o1.y == o2.y) {
                return o1.x - o2.x;
            }

            return o1.y - o2.y;
        });

        for(int i=0; i<N; i++) {
            System.out.println(points[i]);
        }
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}
