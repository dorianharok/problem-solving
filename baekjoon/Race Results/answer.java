import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Time> pq = new PriorityQueue<>();
        while(n-- > 0) {
            pq.add(new Time(br.readLine()));
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            sb.append(pq.poll().toString()).append("\n");
        }

        System.out.println(sb);
    }

    public static class Time implements Comparable<Time> {
        int hour;
        int minute;
        int second;

        public Time(String s) {
            String[] split = s.split(" ");
            this.hour = Integer.parseInt(split[0]);
            this.minute = Integer.parseInt(split[1]);
            this.second = Integer.parseInt(split[2]);
        }

        public int toSeconds() {
            return hour * 3600 + minute * 60 + second;
        }

        public String toString() {
            return hour + " " + minute + " " + second;
        }

        @Override
        public int compareTo(Time o) {
            return this.toSeconds() - o.toSeconds();
        }
    }
}