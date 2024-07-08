import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dirRow = {-1, 0, 1, 0};
    static int[] dirCol = {0, 1, 0, -1};

    static class SnakePoint {
        int row;
        int col;

        SnakePoint(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static class ChangeDirectionInfo {
        int time;
        char dir;

        ChangeDirectionInfo(int time, char dir) {
            this.time = time;
            this.dir = dir;
        }
    }

    static int getGameOverTime (char[][] map, ChangeDirectionInfo[] changeDirectionInfos, int headDirection) {
        int currRow = 0;
        int currCol = 0;
        int time = 0;
        int n = map.length;
        int length = changeDirectionInfos.length;
        Queue<SnakePoint> q = new LinkedList<>();
        q.offer(new SnakePoint(0,0));
        while (true) {
            time++;
            int nextRow = currRow + dirRow[headDirection];
            int nextCol = currCol + dirCol[headDirection];
            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n) {
                return time;
            }
            if (map[nextRow][nextCol] == 's'){
                return time;
            }

            if (map[nextRow][nextCol] != 'a'){
                SnakePoint tailPoint = q.poll();
                map[tailPoint.row][tailPoint.col] = '0';
            }

            map[nextRow][nextCol] = 's';
            q.offer(new SnakePoint(nextRow, nextCol));

            for (int i = 0; i < length; i++) {
                if (time == changeDirectionInfos[i].time) {
                    headDirection = (headDirection + (changeDirectionInfos[i].dir == 'L' ? 3  : 1)) % 4;
                }
            }
            currRow = nextRow;
            currCol = nextCol;

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], '0');
        }

        map[0][0] = 's';
        StringTokenizer st;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;
            map[row][col] = 'a';
        }

        int l = Integer.parseInt(br.readLine());
        ChangeDirectionInfo[] changeDirectionInfos = new ChangeDirectionInfo[l];
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            changeDirectionInfos[i] = new ChangeDirectionInfo(time, dir);
        }

        int headDirection = 1;
        int gameOverTime = getGameOverTime(map, changeDirectionInfos, headDirection);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString(gameOverTime));
        bw.flush();

        br.close();
        bw.close();
    }
}
