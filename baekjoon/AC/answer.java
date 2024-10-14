import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine().replaceAll("[\\[\\]]", "");
            String[] s;
            if (str.isEmpty()) {
                s = new String[0];
            } else {
                s = str.split(",");
            }
            ArrayDeque<String> dq = new ArrayDeque<>();
            boolean asc = true;
            boolean flag = false;

            for(int i = 0; i<s.length; i++) {
                dq.add(s[i]);
            }

            for(char c : p.toCharArray()) {
                if(c == 'R') {
                    asc = !asc;
                    continue;
                }

                if(dq.isEmpty()) {
                    flag = true;
                    break;
                }

                if(asc) {
                    dq.pollFirst();
                } else {
                    dq.pollLast();
                }
            }

            if(flag) {
                System.out.println("error");
                continue;
            }

            StringBuilder sb = new StringBuilder();
            sb.append('[');
            if (!dq.isEmpty()) {
                if (asc) {
                    while(dq.size() > 1) {
                        sb.append(dq.pollFirst()).append(",");
                    }
                    sb.append(dq.pollFirst());
                } else {
                    while(dq.size() > 1) {
                        sb.append(dq.pollLast()).append(",");
                    }
                    sb.append(dq.pollLast());
                }
            }
            sb.append(']');
            System.out.println(sb);
        }
    }
}