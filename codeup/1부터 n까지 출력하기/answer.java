import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        dfs(1, n);
    }

    public static void dfs(int n, int limit) {
        if(n > limit) {
            return;
        }

        System.out.println(n);
        dfs(n + 1, limit);
    }
}