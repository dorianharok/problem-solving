import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static char[][] nodes;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        nodes = new char[3][26];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char a = st.nextToken().charAt(0);
            char l = st.nextToken().charAt(0);
            char r = st.nextToken().charAt(0);

            nodes[0][a-'A'] = a;
            nodes[1][a-'A'] = l;
            nodes[2][a-'A'] = r;
        }

        preOrder(0);
        sb.append("\n");
        inOrder(0);
        sb.append("\n");
        postOrder(0);
        sb.append("\n");

        System.out.println(sb);
    }

    public static void preOrder(int n) {
        if(n >= N) {
            return;
        }
        sb.append(nodes[0][n]);

        if(nodes[1][n] != '.') preOrder(nodes[1][n] - 'A');
        if(nodes[2][n] != '.') preOrder(nodes[2][n] - 'A');
    }

    public static void inOrder(int n) {
        if(n >= N) {
            return;
        }
        if(nodes[1][n] != '.') inOrder(nodes[1][n] - 'A');
        sb.append(nodes[0][n]);
        if(nodes[2][n] != '.') inOrder(nodes[2][n] - 'A');
    }

    public static void postOrder(int n) {
        if(n >= N) {
            return;
        }
        if(nodes[1][n] != '.') postOrder(nodes[1][n] - 'A');
        if(nodes[2][n] != '.') postOrder(nodes[2][n] - 'A');
        sb.append(nodes[0][n]);
    }
}
