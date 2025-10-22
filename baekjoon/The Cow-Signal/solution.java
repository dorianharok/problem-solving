import java.io.*;
import java.util.*;

public class CowSignal {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new FileReader("cowsignal.in"));

        StringTokenizer initial = new StringTokenizer(read.readLine());
        int height = Integer.parseInt(initial.nextToken());
        int width = Integer.parseInt(initial.nextToken());
        int scale = Integer.parseInt(initial.nextToken());

        String[] signal = new String[height];
        for (int r = 0; r < height; r++) { signal[r] = read.readLine(); }

        PrintWriter written = new PrintWriter("cowsignal.out");
        for (int i = 0; i < scale * height; i++) {
            for (int j = 0; j < scale * width; j++) {
                written.print(signal[i / scale].charAt(j / scale));
            }
            written.println();
        }
        written.close();
    }
}