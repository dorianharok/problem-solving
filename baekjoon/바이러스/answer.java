import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static boolean[] visited;
    static int count = 0;
    static List<ArrayList<Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        for(int i=0; i<=n; i++) {
            list.add(new ArrayList<>());
        }
        visited = new boolean[n+1];

        while(m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        visited[1] = true;
        dfs(1);

        System.out.println(count);
    }

    public static void dfs(int x) {
        ArrayList<Integer> computers = list.get(x);

        for(Integer computer: computers) {
            if(visited[computer]) continue;

            visited[computer] = true;
            count++;
            dfs(computer);
        }
    }
}