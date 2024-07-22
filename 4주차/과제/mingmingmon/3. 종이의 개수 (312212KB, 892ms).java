import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
// S2_1780
public class Main {

    static void cutPaper (int n, int startRow, int startCol, int[] result, int[][] paper) {
        int number = paper[startRow][startCol];

        for (int i = startRow; i < startRow + n; i++) {
            for (int j = startCol; j < startCol + n; j++) {
                //System.out.printf("i : %d j : %d\n", i, j);
                if (paper[i][j] == number)
                    continue;

                n /= 3;
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        cutPaper(n, startRow + k * n, startCol + l * n, result, paper);
                    }
                }
                return;
            }
        }

        result[number + 1]++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] paper = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int curr = Integer.parseInt(st.nextToken());
                paper[i][j] = curr;
            }
        }

        int[] result = new int[3];
        cutPaper(n, 0, 0, result, paper);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int cnt : result) {
            bw.write(cnt + "\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }
}
