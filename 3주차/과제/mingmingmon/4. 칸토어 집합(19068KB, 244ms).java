import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static void makeCantorSet(int start, int end, char[] line) {
        if (start == end)
            return;

        int m1 = start + (end - start) * 1 / 3;
        int m2 = start + (end - start) * 2 / 3;
        for (int i = m1 + 1; i <= m2; i++) {
            line[i] = ' ';
        }

        makeCantorSet(start, m1, line);
        makeCantorSet(m2 + 1, end, line);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String input = br.readLine();
            if (input == null)
                break;

            int n = (int)(Math.pow(3, Integer.parseInt(input)));
            char[] line = new char[n];
            Arrays.fill(line, '-');
            makeCantorSet(0, n - 1, line);

            for (char curr : line) {
                bw.write(curr);
            }
            bw.write("\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }
}
