import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
// S4_10994
public class Main {
    static void drawStar (int start, int l, char[][] arr) {
        if (start > l)
            return;

        for (int i = start; i < l + 1; i++) {
            for (int j = start; j < l + 1; j++) {
                if (i == start || i == l || j == start || j == l)
                    arr[i][j] = '*';
                else
                    arr[i][j] = ' ';
            }
        }
        drawStar(start + 2, l - 2, arr);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int l = 4 * (n - 1);
        char[][] arr = new char[l + 1][l + 1];

        drawStar(0, l, arr);

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
