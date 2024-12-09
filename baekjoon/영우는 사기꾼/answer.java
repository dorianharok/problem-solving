import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[N + 1];
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            indegree[b]++;
        }

        int[] buildingCount = new int[N+1];
        while(K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int building = Integer.parseInt(st.nextToken());

            if(command == 1) {
                if(indegree[building] != 0) {
                    System.out.println("Lier!");
                    return;
                }
                buildingCount[building]++;
                if (buildingCount[building] == 1) {
                    for(int n : adj.get(building)) {
                        indegree[n]--;
                    }
                }
            } else {
                if(buildingCount[building] == 0) {
                    System.out.println("Lier!");
                    return;
                }
                buildingCount[building]--;
                if(buildingCount[building] == 0) {
                    for(int n : adj.get(building)) {
                        indegree[n]++;
                    }
                }
            }
        }

        System.out.println("King-God-Emperor");
    }
}
