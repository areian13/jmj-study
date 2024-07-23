import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// S4_10994
public class Main {
    static void drawStar (int start, int end, char[][] arr) {
        if (start > end)
            return;

        for (int i = start; i <= end; i++) {
            arr[start][i] = '*';
            arr[end][i] = '*';
            arr[i][start] = '*';
            arr[i][end] = '*';
        }
        drawStar(start + 2, end - 2, arr);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int size = 4 * (n - 1) + 1;
        char[][] arr = new char[size][size];
        for(char[] rows : arr) {
            Arrays.fill(rows, ' ');
        }

        drawStar(0, size - 1, arr);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (char[] rows : arr) {
            for (char col : rows) {
                bw.write(col);
            }
            bw.write("\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }
}
