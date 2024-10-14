import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            q.add(i);
        }

        st = new StringTokenizer(br.readLine());
        int count = 0;
        while(st.hasMoreTokens()) {
            int mid = q.size() / 2;
            int target = Integer.parseInt(st.nextToken());

            int index = q.indexOf(target);
            if(index <= mid) {
                while(q.peek() != target) {
                    q.addLast(q.poll());
                    count++;
                }
                q.poll();
            } else {
                while(q.peek() != target) {
                    q.addFirst(q.pollLast());
                    count++;
                }
                q.poll();
            }
        }

        System.out.println(count);
    }
}