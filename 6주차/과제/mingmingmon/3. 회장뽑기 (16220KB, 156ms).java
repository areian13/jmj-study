import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
// G5_2660
public class Main {

    static void drawDistanceMap(int n, int[][] distance) {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }
    }

    static int[] getIndividualScore(int n, int[][] distance) {
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int maxDistance = 0;
            for (int j = 1; j <= n; j++) {
                if (i == j)
                    continue;
                maxDistance = Math.max(maxDistance, distance[i][j]);
            }
            result[i] = maxDistance;
        }
        return result;
    }

    static int getCandidateScore(int n, int[] result) {
        int candidateScore = 51;
        for (int i = 1; i <= n; i++) {
            candidateScore = Math.min(candidateScore, result[i]);
        }
        return candidateScore;
    }

    static List<Integer> getCandidateIndex(int n, int candidateScore, int[] result) {
        List<Integer> candidate = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (result[i] != candidateScore)
                continue;
            candidate.add(i);
        }
        return candidate;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] distance = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(distance[i], 51);
        }

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            if (i == -1 && j == -1)
                break;
            distance[i][j] = 1;
            distance[j][i] = 1;
        }

        drawDistanceMap(n, distance);
        int[] result = getIndividualScore(n, distance);
        int candidateScore = getCandidateScore(n, result);
        List<Integer> candidate = getCandidateIndex(n, candidateScore, result);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(candidateScore + " " + candidate.size() + "\n");
        for (int index : candidate) {
            bw.write(index + " ");
        }

        bw.flush();

        br.close();
        bw.close();
    }
}
