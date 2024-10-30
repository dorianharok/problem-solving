import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());
            while (k-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                if (command.equals("I")) {
                    map.put(n, map.getOrDefault(n, 0) + 1);
                } else {
                    if(map.isEmpty()) {
                        continue;
                    }

                    if(n == -1) {
                        Integer i = map.get(map.firstKey());
                        if(i == 1) {
                            map.remove(map.firstKey());
                        } else {
                            map.put(map.firstKey(), i - 1);
                        }
                    } else {
                        Integer i = map.get(map.lastKey());
                        if(i == 1) {
                            map.remove(map.lastKey());
                        } else {
                            map.put(map.lastKey(), i - 1);
                        }
                    }
                }
            }
            if (map.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.printf("%d %d\n", map.lastKey(), map.firstKey());
            }
        }

    }
}