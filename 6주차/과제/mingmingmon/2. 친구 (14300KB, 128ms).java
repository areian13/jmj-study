import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
// S2_1058_2
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] isFriend = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                isFriend[i][j] = line.charAt(j) == 'Y' ? 1 : 51;
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    isFriend[i][j] = Math.min(isFriend[i][j], isFriend[i][k] + isFriend[k][j]);
                }
            }
        }


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max2Friend = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                if (isFriend[i][j] > 2)
                    continue;
                cnt++;
            }
            max2Friend = Math.max(max2Friend, cnt);
        }

        bw.write(Integer.toString(max2Friend));

        bw.flush();

        br.close();
        bw.close();
    }
}
