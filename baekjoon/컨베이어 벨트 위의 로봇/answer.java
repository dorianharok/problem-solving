import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static LinkedList<Belt> conveyor;
    static int count = 0;
    static int length;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        length = 2 * N;

        st = new StringTokenizer(br.readLine());
        conveyor = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            conveyor.add(new Belt(Integer.parseInt(st.nextToken())));
        }

        while (K > 0) {
            count++;
            moveConveyor();
            moveRobot();
        }

        System.out.println(count);
    }

    public static void moveConveyor() {
        conveyor.add(0, conveyor.removeLast());
        if (conveyor.get(N - 1).hasRobot) {
            conveyor.get(N - 1).removeRobot();
        }
    }

    public static void moveRobot() {
        for (int i = N - 2; i >= 0; i--) {
            Belt current = conveyor.get(i);
            Belt next = conveyor.get(i + 1);

            if (!current.hasRobot) continue;

            if (next.canPutRobot()) {
                current.removeRobot();
                next.put();
            }
        }

        if (conveyor.get(N - 1).hasRobot) {
            conveyor.get(N - 1).removeRobot();
        }

        if (conveyor.get(0).canPutRobot()) {
            conveyor.get(0).put();
        }
    }

    public static class Belt {
        int durability;
        boolean hasRobot;

        public Belt(int durability) {
            this.durability = durability;
        }

        public void put() {
            this.hasRobot = true;
            this.durability--;
            if (this.durability == 0) {
                K--;
            }
        }

        public boolean canPutRobot() {
            return this.durability > 0 && !this.hasRobot;
        }

        public void removeRobot() {
            this.hasRobot = false;
        }
    }
}