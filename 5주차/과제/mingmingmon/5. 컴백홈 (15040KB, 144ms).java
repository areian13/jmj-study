import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
//S1_1189
public class Main {

    static int[] dirRow = {-1, 0, 1, 0};
    static int[] dirCol = {0, 1, 0, -1};

    static int countRoadToHome(int currRow, int currCol, int cnt, boolean[][] isVisited, int r, int c, int k, char[][] map) {
        int result = 0;
        if (currRow == 0 && currCol == c - 1) {
            if (cnt == k) {
                result++;
            }
            return result;
        }

        for (int i = 0; i < 4; i++) {
            int nextRow = currRow + dirRow[i];
            int nextCol = currCol + dirCol[i];
            if (nextRow < 0 || nextRow >= r || nextCol < 0 || nextCol >= c)
                continue;
            if (isVisited[nextRow][nextCol])
                continue;
            if (map[nextRow][nextCol] == 'T')
                continue;
            isVisited[nextRow][nextCol] = true;
            result += countRoadToHome(nextRow, nextCol, cnt + 1, isVisited, r, c, k, map);
            isVisited[nextRow][nextCol] = false;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[][] map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        boolean[][] isVisited = new boolean[r][c];
        isVisited[r - 1][0] = true;
        int result = countRoadToHome(r - 1, 0, 1, isVisited, r, c, k, map);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(Integer.toString(result));

        bw.flush();

        br.close();
        bw.close();
    }
}
