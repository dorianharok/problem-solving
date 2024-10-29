import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Number> pq = new PriorityQueue<>(Comparator.comparingInt(Number::getAbs).thenComparing(Number::getNum));
        StringBuilder sb = new StringBuilder();
        while(N-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int abs = Math.abs(n);

            if(n == 0 && pq.isEmpty()) {
                sb.append("0").append("\n");
                continue;
            }

            if(n == 0) {
                sb.append(pq.poll().num).append("\n");
                continue;
            }
            pq.add(new Number(n, abs));
        }

        System.out.println(sb);
    }

    public static class Number {
        private int num;
        private int abs;

        public Number(int num, int abs) {
            this.num = num;
            this.abs = abs;
        }

        public int getNum() {
            return num;
        }

        public int getAbs() {
            return abs;
        }
    }
}