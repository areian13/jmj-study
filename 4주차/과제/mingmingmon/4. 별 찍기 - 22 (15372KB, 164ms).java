import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
// S2_10997
public class Main {
    static void drawStar(int start, int row, int col, char[][] arr) {
        if (col <= 0)
            return;

        for (int i = start; i < start + col; i++) {
            arr[start][i] = '*';
            arr[start + row - 1][i] = '*';
        }

        for (int i = start; i < start + row; i++) {
            arr[i][start] = '*';
        }

        for (int i = start + 2; i < start + row; i++) {
            arr[i][start + col - 1] = '*';
        }
        if (col != 1)
            arr[start + 2][start + col - 2] = '*';

        drawStar(start + 2, row - 4, col - 4, arr);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int row = n == 1 ? 1 : 4 * (n - 1) + 3;
        int col = 4 * (n - 1) + 1;
        char[][] arr = new char[row][col];

        for (char[] rows : arr) {
            Arrays.fill(rows, ' ');
        }

        drawStar(0, row, col, arr);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 1 && j >= 1)
                    break;
                bw.write(arr[i][j]);
            }
            bw.write("\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }
}
