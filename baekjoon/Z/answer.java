import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r, c;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        N = (int) Math.pow(2, N);
        partition(0, 0, N);
    }

    public static void partition(int x, int y, int size) {
        if (size == 1) {
            System.out.println(count);
            return;
        }

        int next = size / 2;

        if(r < x + next && c < y + next) {
            partition(x, y, next);
        } else if (r < x + next && c >= y + next) {
            count += next * next;
            partition(x, y + next, next);
        } else if (r >= x + next && c < y + next) {
            count += next * next * 2;
            partition(x + next, y, next);
        } else {
            count += next * next * 3;
            partition(x + next, y + next, next);
        }
    }
}